package org.example.repository;

import org.example.domain.Sale;
import org.example.domain.Statistic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaticRepo extends CrudRepository<Statistic, Long> {

//    Sale findBySaleList();
    @Query(value = "select count(*) from sale", nativeQuery = true)
    Long countAllSales();
    @Query(value = "select sum(total_cost_sales) from sale", nativeQuery = true)
    Double sumAllSales();
    @Query(value = "select avg(total_cost_sales) from sale", nativeQuery = true)
    Double avgAllSales();
    @Query(value = "select sum(discount) from sale_position", nativeQuery = true)
    Integer sumDiscountAllSales();
    @Query(value = "select sum(total_cost_discount_sales) from sale", nativeQuery = true)
    Double sumAllSalesDiscountCost();
    @Query(value = "select avg(total_cost_discount_sales) from sale", nativeQuery = true)
    Double avgAllSalesDiscountCost();

}
