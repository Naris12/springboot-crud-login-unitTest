package com.example.crud.Service;

import com.example.crud.model.Mlogin;
import com.example.crud.model.Student;
import com.example.crud.repository.studentrepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class Loginservice {

    private final StudentService studentService;
    private final studentrepository studentrepository;





   /* public void login(Mlogin mlogin){

        Optional<Student> opt = studentrepository.findByUsername(mlogin.getUsername());

            if(opt.isEmpty()){
                throw  new IllegalStateException("login fail");
            }
        Student student = opt.get();


            if(!studentService.matchpassword(mlogin.getPassword(),student.getPassword())){
                throw new IllegalStateException("login fail");
            }

        System.out.println("JWT");


    }*/

    public String login2(Mlogin mlogin){
        Optional<Student> opt=studentrepository.findByUsername(mlogin.getUsername());
        if(opt.isEmpty()){
            throw new IllegalStateException("login fail2");
        }
        Student student=opt.get();
        if(!studentService.matchpassword(mlogin.getPassword(), student.getPassword())){
            throw new IllegalStateException("login fail");
        }

        String token ="token";
        return token;
    }



}
