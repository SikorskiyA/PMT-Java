package com.example.pmtjava.model;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "task")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String task;
    @Temporal(TemporalType.DATE)
    private Date finishDate;
    private boolean done;
}
