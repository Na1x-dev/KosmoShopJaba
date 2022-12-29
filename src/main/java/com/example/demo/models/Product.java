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
@RequiredArgsConstructor
@Table(name = "products")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;

    @Column(name = "title")
    @NonNull
    String title;

    @Column(name = "product_count")
    @NonNull
    Integer productCount;

    @Column(name="price")
    @NonNull
    Double price;

    @Column(name = "batch_number")
    @NonNull
    Integer batchNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "best_before_date")
    @NonNull
    Date bestBeforeDate;

    @Column(name="weight")
    @NonNull
    Double weight;

    @ManyToOne
    @JoinColumn(name = "supply_id", nullable = false, referencedColumnName = "supply_id")
    Supply supply;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "category_id")
    @NonNull
    Category category;

    public Product() {
    }

    public String getDateInNormalFormat() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(bestBeforeDate);
    }
    public String formatDateForChange() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(bestBeforeDate);
    }
}
