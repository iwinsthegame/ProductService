package com.productservice.productservice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    //UUID INTERNALY GET CONVERTED INTO BINARY ONLY
    @Id
    @GeneratedValue(generator = "generator_name")
    @GenericGenerator(name ="generator_name", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)",nullable = false, updatable = false)
    private UUID id;

}
