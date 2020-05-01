package com.example.SmartbeeExam1.service;

import com.example.SmartbeeExam1.repository.ClientRepository;
import io.swagger.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ClientService {

    private static boolean isActive(com.example.SmartbeeExam1.model.Client client) {
        return ((null != client) && !client.getDeleted());
    }

    Logger logger = LogManager.getLogger(getClass());

    @Resource
    private ClientRepository clientRepository;

    public ResponseEntity<List<Client>> createClient(List<Client> bodies) {
        try {
            Date now = new Date();
            int nextId = (int)clientRepository.count();

            List<com.example.SmartbeeExam1.model.Client> clients = IntStream.range(0, bodies.size())
                    .mapToObj(index -> {
                        Client body = bodies.get(index);
                        com.example.SmartbeeExam1.model.Client client = new com.example.SmartbeeExam1.model.Client();

                        client.setId(nextId + index);
                        client.setCompanyId(body.getCompanyId());
                        client.setName(body.getName());
                        client.setEmail(body.getEmail());
                        client.setPhone(body.getPhone());
                        client.setCreatedBy(body.getCreatedBy());
                        client.setCreatedAt(now);
                        client.setUpdatedBy(body.getCreatedBy());
                        client.setUpdatedAt(now);
                        client.setDeleted(false);

                        return client;
                    }).collect(Collectors.toList());

            clients = clientRepository.saveAll(clients);

            for (int i = 0; i < clients.size(); ++i) {
                com.example.SmartbeeExam1.model.Client client = clients.get(i);
                Client body = bodies.get(i);
                body.setId(client.getId());
                body.setCreatedAt(now.getTime());
                body.setUpdatedAt(now.getTime());
            }

            return new ResponseEntity<List<Client>>(bodies, HttpStatus.OK);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<List<Client>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Client> readClient(String id) {
        Integer clientId;
        try {
            clientId = Integer.valueOf(id);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
        }

        try {
            com.example.SmartbeeExam1.model.Client client = clientRepository.findById(clientId).orElse(null);
            if (isActive(client)) {
                Client body = new Client();

                body.setId(client.getId());
                body.setName(client.getName());
                body.setEmail(client.getEmail());
                body.setPhone(client.getPhone());
                body.setCreatedBy(client.getCreatedBy());
                body.setCreatedAt(client.getCreatedAt().getTime());
                body.setUpdatedBy(client.getUpdatedBy());
                body.setUpdatedAt(client.getUpdatedAt().getTime());

                return new ResponseEntity<Client>(body, HttpStatus.OK);
            } else {
                return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
            }
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Client> updateClient(String id, Client body) {
        Integer clientId;
        try {
            clientId = Integer.valueOf(id);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
        }

        try {
            com.example.SmartbeeExam1.model.Client client = clientRepository.findById(clientId).orElse(null);
            if (isActive(client)) {
                client.setName(body.getName());
                client.setEmail(body.getEmail());
                client.setPhone(body.getPhone());
                client.setUpdatedBy(body.getUpdatedBy());

                Date now = new Date();
                client.setUpdatedAt(now);

                try {
                    clientRepository.save(client);
                    body.setUpdatedAt(now.getTime());
                    return new ResponseEntity<Client>(body, HttpStatus.OK);
                } catch (Throwable throwable) {
                    logger.error(throwable);
                    return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
            }
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteClient(String id) {
        Integer clientId;
        try {
            clientId = Integer.valueOf(id);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        try {
            com.example.SmartbeeExam1.model.Client client = clientRepository.findById(clientId).orElse(null);
            if (isActive(client)) {
                client.setDeleted(true);

                try {
                    clientRepository.save(client);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                } catch (Throwable throwable) {
                    logger.error(throwable);
                    return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Client>> listClient() {
        try {
            return new ResponseEntity<List<Client>>(clientRepository.findAll().stream()
                    .filter(client -> isActive(client))
                    .map(client -> {
                        Client body = new Client();

                        body.setId(client.getId());
                        body.setName(client.getName());
                        body.setEmail(client.getEmail());
                        body.setPhone(client.getPhone());
                        body.setCreatedBy(client.getCreatedBy());
                        body.setCreatedAt(client.getCreatedAt().getTime());
                        body.setUpdatedBy(client.getUpdatedBy());
                        body.setUpdatedAt(client.getUpdatedAt().getTime());

                        return body;
                    }).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<List<Client>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
