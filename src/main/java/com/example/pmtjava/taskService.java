package com.example.pmtjava;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class taskService {
    @Autowired
    private taskRepo repo;
    public List<task> listAll(String date){
        if (date != null) return repo.search(date);
        else return repo.findAll();
    }
}
