package com.example.task.controller;
import com.example.task.model.Student1;
import com.example.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private  StudentService service;

    @GetMapping("/home")
    public String home() {
        return "redirect:/home.html";
    }
    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/process1")
    public String handleFormSubmission(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
        Student1 person = new Student1();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        service.addstudent(person);
        return "redirect:/form";
    }

}
