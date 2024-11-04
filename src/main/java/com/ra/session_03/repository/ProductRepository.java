package com.ra.session_03.repository;

import com.ra.session_03.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.productName like %:keyword%")
    List<Product> searchByName(String keyword);

}
