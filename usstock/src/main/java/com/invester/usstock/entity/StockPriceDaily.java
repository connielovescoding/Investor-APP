package com.invester.usstock.entity;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock_price_daily")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StockPriceDaily implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Double open;

    private Double high;

    private Double low;

    private Double close;

    private Long volume;

    @ManyToOne
    @JoinColumn(name = "symbol_id", nullable = true)
    private StockSymbol stockSymbol;
    
}
