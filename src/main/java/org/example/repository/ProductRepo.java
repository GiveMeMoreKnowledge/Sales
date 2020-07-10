package org.example.repository;

import org.example.domain.Product;
import org.example.domain.Sale;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    Product findByName(String name);

    @Query(value = "select id from Product order by random()  limit 1",
            nativeQuery = true)
    Long getRandomProduct();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Product set discount_cost = ?1, " +
            "id_discount_product = ?2 where id = ?3",
            nativeQuery = true)
    void updateProduct(Double discountCost, Long idDiscountProduct, Long id);

}
