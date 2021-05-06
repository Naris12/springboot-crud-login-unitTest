package com.example.crud.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class teststudent {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String studentname;
        private String  studentlastname;
        private String email;
}
