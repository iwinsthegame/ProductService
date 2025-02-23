package com.productservice.productservice.inheritancerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaRepository extends JpaRepository<Ta ,Long> {

    @Override
    <S extends Ta> S save(S entity);
}
