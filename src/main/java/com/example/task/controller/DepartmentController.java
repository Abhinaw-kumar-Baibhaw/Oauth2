package com.example.task.controller;

import com.example.task.model.Department;
import com.example.task.model.Student1;
import com.example.task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("department")
    public Department addDepartment(@RequestBody Department department){
        return service.addDep(department);
    }

    @GetMapping("getDepartment")
    public List<Department> getAll(Department department){
        return service.getDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public List<Department> updateDepartment(@PathVariable int id, @RequestBody Department updatedDepartment) {
        return service.updateDepartment(id, updatedDepartment);
    }
}
