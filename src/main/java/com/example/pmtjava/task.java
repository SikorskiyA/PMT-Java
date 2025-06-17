package com.example.pmtjava;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity
public class task {
    @Getter
    private int ID;
    @Getter
    private String task;
    @Getter
    private String FinishDate;
    @Getter
    private boolean IsDone;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getID() {
        return ID;
    }
}
