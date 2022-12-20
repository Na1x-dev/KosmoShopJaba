package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "shifts")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Shift {
    @Id
    @Column(name = "shift_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long shiftId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "open_date")
    @NonNull
    Date openDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "close_date")
    @NonNull
    Date closeDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    @NonNull
    User user;

    public Shift() {
    }
}