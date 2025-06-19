package com.example.pmtjava.controller;

import java.util.List;

import com.example.pmtjava.dto.TaskSaveDTO;
import com.example.pmtjava.dto.TaskUpdateDTO;
import com.example.pmtjava.model.Task;
import com.example.pmtjava.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskSaveDTO taskSaveDTO) {
        Task createdTask = taskService.addTask(taskSaveDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task createdTask = taskService.getTaskById(id);
        return new ResponseEntity<>(createdTask, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody TaskUpdateDTO task) {
        Task updatedTask = taskService.updateTask(id, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/checkTask/{id}")
    public ResponseEntity<Task> checkTask(@PathVariable int id) {
        Task checkedTask = taskService.taskDone(id);
        return new ResponseEntity<>(checkedTask, HttpStatus.OK);
    }

    @GetMapping("/getall/filterbystatus")
    public ResponseEntity<List<Task>> filterByStatus(@RequestParam(value="status") boolean done) {
        return new ResponseEntity<>(taskService.filterByStatus(done), HttpStatus.OK);
    }
}