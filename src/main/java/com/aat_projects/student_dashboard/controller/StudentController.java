package com.aat_projects.student_dashboard.controller;

import com.aat_projects.student_dashboard.dtos.StudentRequestDTO;
import com.aat_projects.student_dashboard.dtos.StudentResponseDTO;
import com.aat_projects.student_dashboard.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    public final StudentService studentService;

    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody StudentRequestDTO request){
        studentService.addStudent(request);
    }
}
