package com.example.SmartbeeExam1.repository;

import com.example.SmartbeeExam1.model.Client;
import io.swagger.Swagger2SpringBoot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = Swagger2SpringBoot.class)
public class ClientRepositoryTests {

    @Resource
    private ClientRepository clientRepository;

    @Test
    public void givenClient_whenSave_thenGetOk() {
        int id = (new Random()).nextInt();
        String name = String.valueOf((new Random()).nextInt());

        Client client1 = buildDummyClient();
        client1.setId(id);
        client1.setName(name);
        clientRepository.save(client1);

        Client client2 = clientRepository.findById(id).orElse(null);
        assertEquals(name, client2.getName());
    }

    @Test
    public void givenClient_whenSave_thenUpdateOk() {
        int id = (new Random()).nextInt();
        String name = String.valueOf((new Random()).nextInt());
        String newName = String.valueOf((new Random()).nextInt());

        Client client1 = buildDummyClient();
        client1.setId(id);
        client1.setName(name);
        clientRepository.save(client1);

        Client client2 = clientRepository.findById(id).orElse(null);
        assertEquals(name, client2.getName());

        client1.setName(newName);
        clientRepository.save(client1);

        Client client3 = clientRepository.findById(id).orElse(null);
        assertEquals(newName, client3.getName());
    }

    @Test
    public void givenClient_whenSave_thenDeleteOk() {
        int id = (new Random()).nextInt();
        String name = String.valueOf((new Random()).nextInt());
        String newName = String.valueOf((new Random()).nextInt());

        Client client1 = buildDummyClient();
        client1.setId(id);
        client1.setName(name);
        clientRepository.save(client1);

        Client client2 = clientRepository.findById(id).orElse(null);
        assertEquals(name, client2.getName());

        client1.setName(newName);
        clientRepository.deleteById(id);

        Client client3 = clientRepository.findById(id).orElse(null);
        assertNull(client3);
    }

    private Client buildDummyClient() {
        Client client = new Client();

        client.setId(-1);
        client.setCompanyId(-1);
        client.setName("");
        client.setEmail("");
        client.setPhone("");
        client.setCreatedBy("");
        client.setCreatedAt(new Date().getTime());
        client.setUpdatedBy("");
        client.setUpdatedAt(new Date().getTime());
        client.setDeleted(false);

        return client;
    }
}
