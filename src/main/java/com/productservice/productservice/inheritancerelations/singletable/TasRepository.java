package com.productservice.productservice.inheritancerelations.singletable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasRepository extends JpaRepository<Ta,Long> {
    @Override
    <S extends Ta> S save(S entity);
}
