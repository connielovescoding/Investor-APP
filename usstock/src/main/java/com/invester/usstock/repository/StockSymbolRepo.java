package com.invester.usstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.invester.usstock.entity.StockSymbol;

@Repository
public interface StockSymbolRepo extends JpaRepository<StockSymbol, Long> {
    
}
