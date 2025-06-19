package com.example.pmtjava.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskUpdateDTO {
    private String task;
    private Date finishDate;
}
