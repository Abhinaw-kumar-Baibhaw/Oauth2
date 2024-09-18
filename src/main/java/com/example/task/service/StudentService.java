package com.example.task.service;

import com.example.task.model.Student1;
import com.example.task.repo.StudRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudRepo repo;

    public Student1 addstudent(Student1 student) {
        return repo.save(student);
    }

    public List<Student1> getStudents(Student1 student) {
        return repo.findAll();
    }

    public void deleteStudentById(int id) {
             repo.deleteById(id);
    }

    public List<Student1> updateStudent(int id, Student1 updatedStudent) {
        Optional<Student1> existingStudentOpt = repo.findById(id);
        if (existingStudentOpt.isPresent()) {
            Student1 existingStudent = existingStudentOpt.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            return Collections.singletonList(repo.save(existingStudent));
        } else {
            throw new EntityNotFoundException("Student not found with id " + id);
        }
    }
}
