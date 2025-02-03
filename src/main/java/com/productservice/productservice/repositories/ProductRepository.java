package com.productservice.productservice.repositories;

import com.productservice.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    <S extends Product> S save(S entity);

    @Override
    List<Product> findAll();

    @Override
    List<Product> findAllById(Iterable<UUID> uuids);
   //  List<Product> findAllByTitle(String Title);

    List<Product> findAllByTitleAndDescription(String title , String description);

    List<Product> findAllByPrice_ValueGreaterThan(double value);

    List<Product> findAllByPrice_ValueLessThan(double value);

   List<Product> findAllByPrice_ValueBetween(Integer x, Integer y);
}
