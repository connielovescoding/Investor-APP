package com.invester.usstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.invester.usstock.entity.StockPriceRealtime;

@Repository
public interface StockPriceRealtimeRepo extends JpaRepository<StockPriceRealtime, Long> {
    
}
