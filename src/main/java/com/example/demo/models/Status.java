package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "statuses")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Status {
    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long statusId;

    @Column(name = "title")
    @NonNull
    String Title;

    public Status() {
    }
}
