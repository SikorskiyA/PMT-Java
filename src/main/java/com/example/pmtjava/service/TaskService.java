package com.example.pmtjava.service;

import java.util.List;

import com.example.pmtjava.dto.TaskSaveDTO;
import com.example.pmtjava.dto.TaskUpdateDTO;
import com.example.pmtjava.model.Task;
import com.example.pmtjava.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    public Task getTaskById(int id){
        return repo.findById(id).orElse(null);
    }

    public Task addTask(TaskSaveDTO taskSaveDTO){
        Task task = new Task();
        task.setFinishDate(taskSaveDTO.getFinishDate());
        task.setTask(taskSaveDTO.getTask());
        return repo.save(task);
    }

    public Task updateTask(int taskId, TaskUpdateDTO taskUpdateDTO){
        Task task = getTaskById(taskId);
        task.setTask(taskUpdateDTO.getTask());
        task.setFinishDate(taskUpdateDTO.getFinishDate());
        return repo.save(task);
    }

    public Task taskDone(int taskId){
        Task task = getTaskById(taskId);
        task.setDone(true);
        return repo.save(task);
    }

    public void deleteTask(int taskId){
        Task task = getTaskById(taskId);
        repo.delete(task);
    }

    public List<Task> filterByStatus(boolean done){
        return repo.findTasksByDone(done);
    }
}
