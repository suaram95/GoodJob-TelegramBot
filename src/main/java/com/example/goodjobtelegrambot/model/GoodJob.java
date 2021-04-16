package com.example.goodjobtelegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "GoodJob")
@Table(name = "good_job")
public class GoodJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int count;
    @Column
    private String comment;
    @ManyToOne
    private Values value;
}
