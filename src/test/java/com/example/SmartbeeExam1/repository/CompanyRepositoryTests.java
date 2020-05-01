package com.example.SmartbeeExam1.repository;

import com.example.SmartbeeExam1.model.Company;
import io.swagger.Swagger2SpringBoot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = Swagger2SpringBoot.class)
public class CompanyRepositoryTests {

    @Resource
    private CompanyRepository companyRepository;

    @Test
    public void givenCompany_whenSave_thenGetOk() {
        int id = (new Random()).nextInt();
        String name = String.valueOf((new Random()).nextInt());

        Company company1 = buildDummyCompany();
        company1.setId(id);
        company1.setName(name);
        companyRepository.save(company1);

        Company company2 = companyRepository.findById(id).orElse(null);
        assertEquals(name, company2.getName());
    }

    @Test
    public void givenCompany_whenSave_thenUpdateOk() {
        int id = (new Random()).nextInt();
        String name = String.valueOf((new Random()).nextInt());
        String newName = String.valueOf((new Random()).nextInt());

        Company company1 = buildDummyCompany();
        company1.setId(id);
        company1.setName(name);
        companyRepository.save(company1);

        Company company2 = companyRepository.findById(id).orElse(null);
        assertEquals(name, company2.getName());
        companyRepository.save(company1);

        company1.setName(newName);
        companyRepository.save(company1);

        Company company3 = companyRepository.findById(id).orElse(null);
        assertEquals(newName, company3.getName());
    }

    @Test
    public void givenCompany_whenSave_thenDeleteOk() {
        int id = (new Random()).nextInt();
        String name = String.valueOf((new Random()).nextInt());
        String newName = String.valueOf((new Random()).nextInt());

        Company company1 = buildDummyCompany();
        company1.setId(id);
        company1.setName(name);
        companyRepository.save(company1);

        Company company2 = companyRepository.findById(id).orElse(null);
        assertEquals(name, company2.getName());

        company1.setName(newName);
        companyRepository.deleteById(id);

        Company company3 = companyRepository.findById(id).orElse(null);
        assertNull(company3);
    }

    private Company buildDummyCompany() {
        Company company = new Company();

        company.setId(-1);
        company.setName("");
        company.setAddress("");
        company.setCreatedBy("");
        company.setCreatedAt(new Date());
        company.setUpdatedBy("");
        company.setUpdatedAt(new Date());
        company.setDeleted(false);

        return company;
    }
}
