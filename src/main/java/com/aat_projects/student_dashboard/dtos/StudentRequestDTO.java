package com.aat_projects.student_dashboard.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {
    private String name;
    private Integer math;
    private Integer physics;
    private Integer  chemistry;
    private Integer computer;
    private Integer english;
}
