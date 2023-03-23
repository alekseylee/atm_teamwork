package com.example.atm.data.repositories;

import com.example.atm.data.entities.AtmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepository extends JpaRepository<AtmEntity,Long> {
}
