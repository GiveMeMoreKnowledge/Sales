package org.example.repository;

import org.example.domain.SalePosition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SalePositionRepo extends CrudRepository<SalePosition, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update SalePosition set discount = ?1 where id = ?2",
            nativeQuery = true)
    void updateDiscount(Double discountCost, Long id);

}
