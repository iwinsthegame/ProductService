package com.productservice.productservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    @Column(nullable = false, unique = true)
    private String name;


    //this is redudency ..this is duplicate relation
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
