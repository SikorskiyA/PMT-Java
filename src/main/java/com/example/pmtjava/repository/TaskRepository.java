package com.example.pmtjava.repository;


import com.example.pmtjava.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findTasksByDone(boolean done);
}

