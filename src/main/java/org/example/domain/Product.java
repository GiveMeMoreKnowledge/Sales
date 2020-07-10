package org.example.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;
    private Double cost;
    private Double discountCost;
    private Long idDiscountProduct;

    public Product() {}

    public Product(String name, Double cost) {
        this.name = name;
        this.cost = cost;
        this.discountCost = 0.0;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(Double discountCost) {
        this.discountCost = discountCost;
    }

    public Long getIdDiscountProduct() {
        return idDiscountProduct;
    }

    public void setIdDiscountProduct(Long idDiscountProduct) {
        this.idDiscountProduct = idDiscountProduct;
    }

}
