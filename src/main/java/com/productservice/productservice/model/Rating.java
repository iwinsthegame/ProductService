package com.productservice.productservice.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rating extends BaseModel{
    private double rate;
    private int count;

}
