package com.example.crud.repository;

import com.example.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentrepository extends JpaRepository<Student,Long> {

    Optional<Student> findStudentByEmail(String email);
    Optional<Student>findStudentByname(String name);
    Optional<Student>findByUsername(String username);

}
