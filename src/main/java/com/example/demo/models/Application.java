package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "applications")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Application {
    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long applicationId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "open_date")
    @NonNull
    Date openDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "close_date")
    @NonNull
    Date closeDate;

    @Column(name="description")
    @NonNull
    String description;

    @Column(name="comment")
    @NonNull
    String comment;

    @ManyToOne
    @JoinColumn(name = "user_id_open", nullable = false, referencedColumnName = "id")
    @NonNull
    User userOpen;
    @ManyToOne
    @JoinColumn(name = "user_id_close", nullable = false, referencedColumnName = "id")
    @NonNull
    User userClose;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false, referencedColumnName = "status_id")
    @NonNull
    Status status;

    public Application() {
    }

//    public String formatDateForChange() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        return format.format(registerDate);
//    }
//
//    public String getDateInNormalFormat() {
//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//        return format.format(registerDate);
//    }
}
