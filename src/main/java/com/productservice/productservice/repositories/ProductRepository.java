package com.productservice.productservice.repositories;

import com.productservice.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    <S extends Product> S save(S entity);
}
