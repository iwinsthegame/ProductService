package com.productservice.productservice.dtos;

import com.productservice.productservice.model.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {

    private Long id;
    private String title;
    private int price;
    //in fakestore category is String so we have taken category as String
    private String category;
    private String description;
    private String image;
    private Rating rating;
}
