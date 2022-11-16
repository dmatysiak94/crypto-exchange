package com.example.elisity.repository;

import com.example.elisity.entity.CryptoCurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrencyEntity, Long> {
    
}
