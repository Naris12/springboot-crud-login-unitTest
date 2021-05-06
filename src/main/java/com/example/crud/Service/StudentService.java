package com.example.crud.Service;

import com.example.crud.model.Student;
import com.example.crud.repository.studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final studentrepository studentrepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(com.example.crud.repository.studentrepository studentrepository, PasswordEncoder passwordEncoder) {
        this.studentrepository = studentrepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<Student>getstudent() {
    return studentrepository.findAll();

    }

    /*public void addnewstudent(Student student){
        Optional<Student> studentByEmail = studentrepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentrepository.save(student);
    }
*/
    public Student addnewstudent(String name, String email, String username, String password){

        if(Objects.isNull(name)||name.length()==0){
            throw new IllegalStateException("name null");
        }
        if(Objects.isNull(email)||email.length()==0){
            throw new IllegalStateException("email null");
        }
        Optional<Student> studentByEmail = studentrepository.findStudentByEmail(email);
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");

        }
        Student student= new Student();
        student.setName(name);
        student.setEmail(email);
        student.setUsername(username);
        student.setPassword(passwordEncoder.encode(password));
        studentrepository.save(student);

        return student;
    }

    public boolean matchpassword(String rawpassword,String encodepassword){
       return passwordEncoder.matches(rawpassword,encodepassword);
    }

    public Optional<Student> findStudentByEmail(String email){
        return studentrepository.findStudentByEmail(email);
    }




    public void deleteStudent(Long studentId) {

        boolean exists = studentrepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+studentId+"does not exists");
        }
        studentrepository.deleteById(studentId);
    }

    @Transactional
    public Student update (Long studentid, String name, String email){
        Student student = studentrepository.findById(studentid).orElseThrow(()-> new IllegalStateException
                ("student with id "+studentid+"does not exists"));




        if(name!=null&&name.length()>0&&!Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email!=null&&email.length()>0&&!Objects.equals(student.getEmail(),email)){
            Optional<Student> studentByEmail = studentrepository.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

        return student;
    }


}
