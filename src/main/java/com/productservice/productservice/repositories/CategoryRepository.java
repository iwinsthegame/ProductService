package com.productservice.productservice.repositories;

import com.productservice.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    <S extends Category> S save(S entity);
}
