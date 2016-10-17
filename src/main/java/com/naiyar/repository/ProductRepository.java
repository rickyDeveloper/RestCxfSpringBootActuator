package com.naiyar.repository;

import com.naiyar.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
   Product findById(Long id);
/*
   @Query(value = "select p from Product p where p.name like %:searchText% or p.location like %:searchText%")
   Collection<Product> findMatchingProducts(@Param("searchText") String searchText);
  */

   List<Product> findByNameContaining(String searchText);

}
