package com.productservice.productservice.inheritancerelations.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@Inheritance(strategy =  InheritanceType.JOINED)
@Entity(name="jt_user")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private String email;
}
