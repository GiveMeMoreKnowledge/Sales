package org.example.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer discount;
    private LocalDateTime date;

    public Statistic() {
    }

    public Statistic(LocalDateTime date, String name, Integer discount) {
        this.date = date;
        this.name = name;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDate() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy в hh:mm:ss");
        return FOMATTER.format(date);
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
