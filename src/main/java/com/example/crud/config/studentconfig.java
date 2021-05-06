package com.example.crud.config;

import com.example.crud.model.Student;
import com.example.crud.repository.studentrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class studentconfig {
   /* @Bean
    CommandLineRunner commandLineRunner(
            studentrepository studentrepository){

        return args -> {
            Student ris = new Student(

                    "ris",
                    "ris@gmail.com",
                    "naris",
                    "1234"

            );

            Student test = new Student(
                    "test",
                    "test@email.com",
                    "ris",
                    "1234"
            );
            studentrepository.saveAll(
                    List.of(ris,test)
            );
        };
    }
*/
}
