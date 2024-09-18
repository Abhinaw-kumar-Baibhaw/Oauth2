package com.example.task.controller;

import org.springframework.ui.Model;
import com.example.task.model.Student1;
import com.example.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@RequestMapping("/Students")
public class StudentController {

    @Autowired
    private StudentService service;



    @GetMapping("/hello")
    public String sayHello(@AuthenticationPrincipal UserDetails user) {
        return "Hello, " + (user != null ? user.getUsername() : "Guest") + "!";
    }

    @PostMapping("student")
    public Student1 addStudent(@RequestBody Student1 student){
        return service.addstudent(student);
    }

    @GetMapping("getStudents")
    public List<Student1> getAll(Student1 student){
        return service.getStudents(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudentById(id);
    }


    @PutMapping("/{id}")
    public List<Student1> updateStudent(@PathVariable int id, @RequestBody Student1 updatedStudent) {
        return service.updateStudent(id, updatedStudent);
    }
}
