package com.aat_projects.student_dashboard.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;


    private Integer math;


    private Integer physics;


    private Integer chemistry;


    private Integer computer;


    private Integer english;

    private double cgpa;

    private Category category;

    private String feedback;

}

