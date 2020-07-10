package org.example.repository;

import org.example.domain.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends CrudRepository<Sale, Long> {}
