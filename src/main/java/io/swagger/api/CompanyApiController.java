package io.swagger.api;

import com.example.SmartbeeExam1.service.CompanyService;
import io.swagger.model.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-05-01T16:46:06.832+08:00")

@Controller
public class CompanyApiController implements CompanyApi {

    @Autowired
    private CompanyService companyService;

    @Override
    public ResponseEntity<List<Company>> createCompany(List<Company> bodies) {
        String userName = getUserName();
        bodies.stream().forEach(body -> body.setCreatedBy(userName));
        return companyService.createCompany(bodies);
    }

    @Override
    public ResponseEntity<Company> readCompany(String id) {
        return companyService.readCompany(id);
    }

    @Override
    public ResponseEntity<Company> updateCompany(String id, Company body) {
        body.setUpdatedBy(getUserName());
        return companyService.updateCompany(id, body);
    }

    @Override
    public ResponseEntity<Void> deleteCompany(String id) {
        return companyService.deleteCompany(id);
    }

    @Override
    public ResponseEntity<List<Company>> listCompany() {
        return companyService.listCompany();
    }

    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
