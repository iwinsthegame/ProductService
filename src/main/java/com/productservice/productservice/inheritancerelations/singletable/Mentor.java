package com.productservice.productservice.inheritancerelations.singletable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentors")
public class Mentor extends User {
    private double avgRating;
}
