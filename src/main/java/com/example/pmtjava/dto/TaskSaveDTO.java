package com.example.pmtjava.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskSaveDTO {
    private String task;
    private Date finishDate;
    private boolean isDone;
}
