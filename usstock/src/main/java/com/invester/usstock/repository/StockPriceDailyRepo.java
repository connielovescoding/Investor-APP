package com.invester.usstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.invester.usstock.entity.StockPriceDaily;

@Repository
public interface StockPriceDailyRepo extends JpaRepository<StockPriceDaily, Long> {
    
}
