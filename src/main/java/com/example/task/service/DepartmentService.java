package com.example.task.service;

import com.example.task.model.Department;
import com.example.task.model.Student1;
import com.example.task.repo.DepartmentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    public Department addDep(Department department) {
        return repo.save(department);
    }

    public List<Department> getDepartment(Department department) {
        return repo.findAll();
    }

    public void deleteStudentById(int id) {
        repo.deleteById(id);
    }

    public List<Department> updateDepartment(int id, Department updatedDepartment) {
        Optional<Department> existingStudentOpt = repo.findById(id);
        if (existingStudentOpt.isPresent()) {
            Department existingStudent = existingStudentOpt.get();
            existingStudent.setDep_id(updatedDepartment.getDep_id());
            existingStudent.setDep_name(updatedDepartment.getDep_name());
            return Collections.singletonList(repo.save(existingStudent));
        } else {
            throw new EntityNotFoundException("Student not found with id " + id);
        }
    }
}
