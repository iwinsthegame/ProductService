package com.productservice.productservice;

import com.productservice.productservice.inheritancerelations.mappedsuperclass.Mentor;
import com.productservice.productservice.inheritancerelations.mappedsuperclass.MentorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

       private MentorRepository mentorRepository;

       ProductServiceApplication(@Qualifier("ms_mentorrepository") MentorRepository mentorRepository){
           this.mentorRepository =mentorRepository;
       }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setAvgRating(9.87);
        mentor.setEmail("ravikumar21987@gmail.com");
        mentor.setName("Ravi");

        mentorRepository.save(mentor);

        //com.productservice.productservice.inheritancerelations.tableperclass.Mentor mentor1 = new com.productservice.productservice.inheritancerelations.tableperclass.Mentor();
    }
}
