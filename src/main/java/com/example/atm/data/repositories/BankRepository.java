package com.example.atm.data.repositories;

import com.example.atm.data.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity, Long> {
}
