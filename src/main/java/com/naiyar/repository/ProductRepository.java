package com.naiyar.repository;

import com.naiyar.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
   Product findById(Long id);
}
