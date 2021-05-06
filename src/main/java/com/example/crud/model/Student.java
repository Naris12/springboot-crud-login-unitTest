package com.example.crud.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName ="student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;

    private String name;
    @Column(nullable = false)
    private String email;
    private String username;
    private String password;

    public Student(long id, String name, String email,String username,String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username=username;
        this.password=password;

    }

    public Student() {
    }

    public Student(String name, String email,String username,String password) {
        this.name = name;
        this.email = email;
        this.username= username;
        this.password=password;
    }
}
