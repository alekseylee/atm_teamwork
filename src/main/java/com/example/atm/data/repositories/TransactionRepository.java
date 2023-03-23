package com.example.atm.data.repositories;

import com.example.atm.data.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
