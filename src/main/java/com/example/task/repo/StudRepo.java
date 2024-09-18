package com.example.task.repo;

import com.example.task.model.Student1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudRepo extends JpaRepository<Student1,Integer> {
}
