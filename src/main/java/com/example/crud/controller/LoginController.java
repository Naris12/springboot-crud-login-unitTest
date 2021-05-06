package com.example.crud.controller;

import com.example.crud.Service.Loginservice;
import com.example.crud.model.Mlogin;
import com.example.crud.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private  final Loginservice loginservice;



    @PostMapping
    public ResponseEntity<String >login(@RequestBody Mlogin mlogin){
        String s = loginservice.login2(mlogin);
        return ResponseEntity.ok(s);
    }
}
