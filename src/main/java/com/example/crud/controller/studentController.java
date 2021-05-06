package com.example.crud.controller;

import com.example.crud.Service.StudentService;
import com.example.crud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/crud")
public class studentController {

    private final StudentService studentService;

    @Autowired
    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> hello(){
    return studentService.getstudent();
    }

    @PostMapping
    public void registerNewStudent( @RequestBody Student student){
        studentService.addnewstudent(student.getName(), student.getEmail(),student.getUsername(),
                student.getPassword());
    }

    @DeleteMapping(path = "{studentId}")
    public void deletestudent(@PathVariable ("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentid}")
    public void updatestudent(
            @PathVariable("studentid")Long studentid,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String email

    ){
        studentService.update(studentid,name,email);
    }
}
