package com.productservice.productservice;


import com.productservice.productservice.inheritancerelations.tableperclass.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final MentorRepository mentorRepository;

    private final StudentsRepository studentsRepository;
    private final UserRepository userRepository;

//       ProductServiceApplication(@Qualifier("ms_mentorrepository") MentorRepository mentorRepository){
//           this.mentorRepository =mentorRepository;
//       }

    ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository, StudentsRepository studentsRepository, UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.studentsRepository = studentsRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //ms_mappedsuperclass
//        Mentor mentor = new Mentor();
//        mentor.setAvgRating(9.87);
//        mentor.setEmail("ravikumar21987@gmail.com");
//        mentor.setName("Ravi");
//
//        mentorRepository.save(mentor);
        // doing for tableper claass
        //com.productservice.productservice.inheritancerelations.tableperclass.Mentor mentor1 = new com.productservice.productservice.inheritancerelations.tableperclass.Mentor();
//ms_tableperclass
        Mentor mentor = new Mentor();
        mentor.setAvgRating(7.87);
        mentor.setEmail("youavikumar21987@gmail.com");
        mentor.setName("mehak");

        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("halala");
        student.setEmail("bolojai@scaler.com");
        student.setPsp(99.45);

        studentsRepository.save(student);

        User user = new User();
        user.setEmail("kahonapyaar@scaler.com");
        user.setName("Hum hai n");

        userRepository.save(user);


        //get all the user
        List<User> users = userRepository.findAll();
        for(User user1 : users){
            System.out.println(user1.toString());
        }

    }
}
