package com.invester.usstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.invester.usstock.entity.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {
    
}
