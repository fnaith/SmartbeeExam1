package com.example.SmartbeeExam1.service;

import com.example.SmartbeeExam1.repository.CompanyRepository;
import io.swagger.model.Company;
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
public class CompanyService {

    private static boolean isActive(com.example.SmartbeeExam1.model.Company company) {
        return ((null != company) && !company.getDeleted());
    }

    private static Company buildBody(com.example.SmartbeeExam1.model.Company company) {
        Company body = new Company();

        body.setId(company.getId());
        body.setName(company.getName());
        body.setAddress(company.getAddress());
        body.setCreatedBy(company.getCreatedBy());
        body.setCreatedAt(company.getCreatedAt().getTime());
        body.setUpdatedBy(company.getUpdatedBy());
        body.setUpdatedAt(company.getUpdatedAt().getTime());

        return body;
    }

    Logger logger = LogManager.getLogger(getClass());

    @Resource
    private CompanyRepository companyRepository;

    public ResponseEntity<List<Company>> createCompany(List<Company> bodies) {
        try {
            Date now = new Date();
            int nextId = (int)companyRepository.count();

            List<com.example.SmartbeeExam1.model.Company> companies = IntStream.range(0, bodies.size())
                    .mapToObj(index -> {
                        Company body = bodies.get(index);
                        body.setUpdatedBy(body.getCreatedBy());

                        com.example.SmartbeeExam1.model.Company company = new com.example.SmartbeeExam1.model.Company();

                        company.setId(nextId + index);
                        company.setName(body.getName());
                        company.setAddress(body.getAddress());
                        company.setCreatedBy(body.getCreatedBy());
                        company.setCreatedAt(now);
                        company.setUpdatedBy(body.getUpdatedBy());
                        company.setUpdatedAt(now);
                        company.setDeleted(false);

                        return company;
                    }).collect(Collectors.toList());

            companies = companyRepository.saveAll(companies);

            for (int i = 0; i < companies.size(); ++i) {
                com.example.SmartbeeExam1.model.Company company = companies.get(i);
                Company body = bodies.get(i);
                body.setId(company.getId());
                body.setCreatedAt(now.getTime());
                body.setUpdatedAt(now.getTime());
            }

            return new ResponseEntity<>(bodies, HttpStatus.OK);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Company> readCompany(String id) {
        Integer companyId;
        try {
            companyId = Integer.valueOf(id);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            com.example.SmartbeeExam1.model.Company company = companyRepository.findById(companyId).orElse(null);
            if (isActive(company)) {
                return new ResponseEntity<>(buildBody(company), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Company> updateCompany(String id, Company body) {
        Integer companyId;
        try {
            companyId = Integer.valueOf(id);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            com.example.SmartbeeExam1.model.Company company = companyRepository.findById(companyId).orElse(null);
            if (isActive(company)) {
                company.setName(body.getName());
                company.setAddress(body.getAddress());
                company.setUpdatedBy(body.getUpdatedBy());

                Date now = new Date();
                company.setUpdatedAt(now);

                try {
                    companyRepository.save(company);
                    body.setId(companyId);
                    body.setUpdatedAt(now.getTime());
                    return new ResponseEntity<>(body, HttpStatus.OK);
                } catch (Throwable throwable) {
                    logger.error(throwable);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteCompany(String id) {
        Integer companyId;
        try {
            companyId = Integer.valueOf(id);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            com.example.SmartbeeExam1.model.Company company = companyRepository.findById(companyId).orElse(null);
            if (isActive(company)) {
                company.setDeleted(true);

                try {
                    companyRepository.save(company);
                    return new ResponseEntity<>(HttpStatus.OK);
                } catch (Throwable throwable) {
                    logger.error(throwable);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Company>> listCompany() {
        try {
            return new ResponseEntity<>(companyRepository.findAll().stream().filter(company -> isActive(company))
                    .map(company -> buildBody(company)).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Throwable throwable) {
            logger.error(throwable);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
