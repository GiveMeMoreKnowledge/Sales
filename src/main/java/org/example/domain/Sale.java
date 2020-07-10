package org.example.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private LocalDateTime date;
    private Double totalCostSales;
    private Double totalCostDiscountSales;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sales_id")
    private List<SalePosition> salePositions = new ArrayList<>();

    public Sale() {}

    public Sale(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
        this.totalCostSales = 0.0;
        this.totalCostDiscountSales = 0.0;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDate() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy в hh:mm:ss");
        return FOMATTER.format(date);
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<SalePosition> getSalePositions() {
        return salePositions;
    }

    public void setSalePositions(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
    }

    public Double getTotalCostSales() {
        return totalCostSales;
    }

    public void setTotalCostSales(Double totalCostSales) {
        this.totalCostSales = totalCostSales;
    }

    public Double getTotalCostDiscountSales() {
        return totalCostDiscountSales;
    }

    public void setTotalCostDiscountSales(Double totalCostDiscountSales) {
        this.totalCostDiscountSales = totalCostDiscountSales;
    }

}
