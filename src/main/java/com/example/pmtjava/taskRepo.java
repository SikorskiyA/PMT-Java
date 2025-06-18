package com.example.pmtjava;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface taskRepo extends JpaRepository<task, Integer> {
    @Query("SELECT t FROM task t WHERE CONCAT(t.ID, t.task, t.finishDate, t.isDone) LIKE %?1%")
    public List<task> search(String date);
}
