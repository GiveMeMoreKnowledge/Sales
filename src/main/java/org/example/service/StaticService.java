package org.example.service;

import org.example.domain.Statistic;
import org.example.repository.StaticRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StaticService {

    private final StaticRepo staticRepo;

    public StaticService(StaticRepo staticRepo) {
        this.staticRepo = staticRepo;
    }

    public void addStatistic(LocalDateTime date, String name, Integer discount) {
        Statistic statistic = new Statistic(date, name, discount);
        staticRepo.save(statistic);
    }

    public Iterable<Statistic> findAll() {
        return staticRepo.findAll();
    }

    public Long countAllSales() {
        return staticRepo.countAllSales();
    }

    public Double sumAllSales() {
        return staticRepo.sumAllSales();
    }

    public Double avgAllSales() {
        return staticRepo.avgAllSales();
    }

    public Integer sumDiscountAllSales() {
        return staticRepo.sumDiscountAllSales();
    }

    public Double sumAllSalesDiscountCost() {
        return staticRepo.sumAllSalesDiscountCost();
    }

    public Double avgAllSalesDiscountCost() {
        return staticRepo.avgAllSalesDiscountCost();
    }

}
