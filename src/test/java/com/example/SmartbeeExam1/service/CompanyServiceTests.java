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
public class CompanyServiceTests {

    @Autowired
    private CompanyService companyService;

    @Test
    public void givenCompany_whenSave_thenGetOk() {
        String name = String.valueOf((new Random()).nextInt());

        io.swagger.model.Company body1 = buildDummyBody();
        body1.setName(name);
        List<io.swagger.model.Company> bodies = companyService.createCompany(Arrays.asList(body1)).getBody();

        String id = bodies.get(0).getId().toString();
        io.swagger.model.Company body2 = companyService.readCompany(id).getBody();
        assertEquals(name, body2.getName());
    }

    @Test
    public void givenCompanies_whenSave_thenGetAllOk() {
        List<io.swagger.model.Company> bodies1 = companyService.listCompany().getBody();

        String name = String.valueOf((new Random()).nextInt());

        io.swagger.model.Company body = buildDummyBody();
        body.setName(name);
        List<io.swagger.model.Company> bodies2 = companyService.createCompany(IntStream.range(0, (new Random()).nextInt() % 20)
                .mapToObj(i -> body).collect(Collectors.toList())).getBody();

        List<io.swagger.model.Company> bodies3 = companyService.listCompany().getBody();
        assertEquals(bodies3.size(), bodies1.size() + bodies2.size());
    }

    @Test
    public void givenCompany_whenSave_thenUpdateOk() {
        String name = String.valueOf((new Random()).nextInt());
        String newName = String.valueOf((new Random()).nextInt());

        io.swagger.model.Company body1 = buildDummyBody();
        body1.setName(name);
        List<io.swagger.model.Company> bodies = companyService.createCompany(Arrays.asList(body1)).getBody();

        String id = bodies.get(0).getId().toString();
        io.swagger.model.Company body2 = companyService.readCompany(id).getBody();
        assertEquals(name, body2.getName());

        body1.setName(newName);
        io.swagger.model.Company body3 = companyService.updateCompany(id, body1).getBody();
        assertEquals(newName, body3.getName());
    }

    @Test
    public void givenCompany_whenSave_thenDeleteOk() {
        String name = String.valueOf((new Random()).nextInt());

        io.swagger.model.Company body1 = buildDummyBody();
        body1.setName(name);
        List<io.swagger.model.Company> bodies = companyService.createCompany(Arrays.asList(body1)).getBody();

        String id = bodies.get(0).getId().toString();
        io.swagger.model.Company body2 = companyService.readCompany(id).getBody();
        assertEquals(name, body2.getName());

        companyService.deleteCompany(id);
        assertEquals(HttpStatus.NOT_FOUND, companyService.readCompany(id).getStatusCode());
    }

    private io.swagger.model.Company buildDummyBody() {
        io.swagger.model.Company body = new io.swagger.model.Company();

        body.setId(-1);
        body.setName("");
        body.setAddress("");
        body.setCreatedBy("");
        body.setCreatedAt(new Date().getTime());
        body.setUpdatedBy("");
        body.setUpdatedAt(new Date().getTime());

        return body;
    }
}
