package com.example.SmartbeeExam1.service;

import io.swagger.Swagger2SpringBoot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Swagger2SpringBoot.class)
public class ClientServiceTests {

    @Autowired
    private ClientService clientService;

    @Test
    public void givenClient_whenSave_thenGetOk() {
        String name = String.valueOf((new Random()).nextInt());

        io.swagger.model.Client body1 = buildDummyBody();
        body1.setName(name);
        List<io.swagger.model.Client> bodies = clientService.createClient(Arrays.asList(body1)).getBody();

        String id = bodies.get(0).getId().toString();
        io.swagger.model.Client body2 = clientService.readClient(id).getBody();
        assertEquals(name, body2.getName());
    }

    @Test
    public void givenCompanies_whenSave_thenGetAllOk() {
        List<io.swagger.model.Client> bodies1 = clientService.listClient().getBody();

        String name = String.valueOf((new Random()).nextInt());

        io.swagger.model.Client body = buildDummyBody();
        body.setName(name);
        List<io.swagger.model.Client> bodies2 = clientService.createClient(IntStream.range(0, (new Random()).nextInt() % 20)
                .mapToObj(i -> body).collect(Collectors.toList())).getBody();

        List<io.swagger.model.Client> bodies3 = clientService.listClient().getBody();
        assertEquals(bodies3.size(), bodies1.size() + bodies2.size());
    }

    @Test
    public void givenClient_whenSave_thenUpdateOk() {
        String name = String.valueOf((new Random()).nextInt());
        String newName = String.valueOf((new Random()).nextInt());

        io.swagger.model.Client body1 = buildDummyBody();
        body1.setName(name);
        List<io.swagger.model.Client> bodies = clientService.createClient(Arrays.asList(body1)).getBody();

        String id = bodies.get(0).getId().toString();
        io.swagger.model.Client body2 = clientService.readClient(id).getBody();
        assertEquals(name, body2.getName());

        body1.setName(newName);
        io.swagger.model.Client body3 = clientService.updateClient(id, body1).getBody();
        assertEquals(newName, body3.getName());
    }

    @Test
    public void givenClient_whenSave_thenDeleteOk() {
        String name = String.valueOf((new Random()).nextInt());

        io.swagger.model.Client body1 = buildDummyBody();
        body1.setName(name);
        List<io.swagger.model.Client> bodies = clientService.createClient(Arrays.asList(body1)).getBody();

        String id = bodies.get(0).getId().toString();
        io.swagger.model.Client body2 = clientService.readClient(id).getBody();
        assertEquals(name, body2.getName());

        clientService.deleteClient(id);
        assertEquals(HttpStatus.NOT_FOUND, clientService.readClient(id).getStatusCode());
    }

    private io.swagger.model.Client buildDummyBody() {
        io.swagger.model.Client body = new io.swagger.model.Client();

        body.setId(-1);
        body.setCompanyId(-1);
        body.setName("");
        body.setEmail("");
        body.setPhone("");
        body.setCreatedBy("");
        body.setCreatedAt(new Date().getTime());
        body.setUpdatedBy("");
        body.setUpdatedAt(new Date().getTime());

        return body;
    }
}
