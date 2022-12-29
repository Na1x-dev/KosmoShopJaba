package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "supplies")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Supply {
    @Id
    @Column(name = "supply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long supplyId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "supply_date")
    @NonNull
    Date supplyDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, referencedColumnName = "supplier_id")
    @NonNull
    Supplier supplier;

    public Supply() {
    }

//    public String formatDateForChange() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        return format.format(meetingMinuteDate);
//    }
//
    public String getDateInNormalFormat() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(supplyDate);
    }
}
