package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "orders")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "order_date")
    @NonNull
    Date orderDate;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false, referencedColumnName = "delivery_id")
    @NonNull
    Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "product_id")
    @NonNull
    Product product;

    public Order() {
    }

        public String getDateInNormalFormat() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(orderDate);
    }

//    public String getIdAndName() {
//        if (!surname.equals("") || !name.equals("") || !patronymic.equals(""))
//            return unionMemberId + ". " + surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
//        return "";
//    }
//
//    public String getDateInNormalFormat() {
//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//        return format.format(birthdate);
//    }
//
//    public String formatDateForChange() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        return format.format(birthdate);
//    }
//
//    @Override
//    public String toString() {
//        return "UnionMember{" +
//                "unionMemberId=" + unionMemberId +
//                ", surname='" + surname + '\'' +
//                ", name='" + name + '\'' +
//                ", patronymic='" + patronymic + '\'' +
//                ", phone='" + products.get(0).phoneNumber + '\'' +
//                '}';
//    }
}
