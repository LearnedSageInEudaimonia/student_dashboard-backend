package com.aat_projects.student_dashboard.mapper;

import com.aat_projects.student_dashboard.dtos.StudentResponseDTO;
import com.aat_projects.student_dashboard.entity.Student;

public class StudentMapper {

    public static StudentResponseDTO toResponse(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .math(student.getMath())
                .chemistry(student.getChemistry())
                .physics(student.getPhysics())
                .computer(student.getComputer())
                .english(student.getEnglish())
                .cgpa(student.getCgpa())
                .category(String.valueOf(student.getCategory()))
                .feedback(student.getFeedback())
                .build();
    }
}