package com.productservice.productservice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Product extends BaseModel {


    private String title;
    private String description;
   // private int price;
    private String image;

    //category isn't a primitive attribute. it's a relation
    @ManyToOne(optional = false)
   // @JoinColumn(nullable = false)
    private Category category;//here u cannot create a product without category

    //@OneToOne(optional = false)
   // @JoinColumn(nullable = false)
    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Price price;//similary u cannot create product without price


/*  1       1
* product category cardinality
* m        1
*
* */

}
