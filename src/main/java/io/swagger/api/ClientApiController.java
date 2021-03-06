package io.swagger.api;

import com.example.SmartbeeExam1.service.ClientService;
import io.swagger.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-05-01T19:39:44.457+08:00")

@Controller
public class ClientApiController implements ClientApi {

    @Autowired
    private ClientService clientService;

    @Override
    public ResponseEntity<List<Client>> createClient(List<Client> bodies) {
        String userName = getUserName();
        bodies.stream().forEach(body -> body.setCreatedBy(userName));
        return clientService.createClient(bodies);
    }

    @Override
    public ResponseEntity<Client> readClient(String id) {
        return clientService.readClient(id);
    }

    @Override
    public ResponseEntity<Client> updateClient(String id, Client body) {
        body.setUpdatedBy(getUserName());
        return clientService.updateClient(id, body);
    }

    @Override
    public ResponseEntity<Void> deleteClient(String id) {
        return clientService.deleteClient(id);
    }

    @Override
    public ResponseEntity<List<Client>> listClient() {
        return clientService.listClient();
    }

    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
