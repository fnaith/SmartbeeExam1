package com.example.SmartbeeExam1.repository;

import com.example.SmartbeeExam1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
