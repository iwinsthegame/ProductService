package com.productservice.productservice.inheritancerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student,Long> {
    @Override
    <S extends Student> S save(S entity);
}
