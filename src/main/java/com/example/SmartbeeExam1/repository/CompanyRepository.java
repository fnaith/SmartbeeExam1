package com.example.SmartbeeExam1.repository;

import com.example.SmartbeeExam1.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
