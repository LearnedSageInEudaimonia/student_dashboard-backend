package com.aat_projects.student_dashboard.service;

import com.aat_projects.student_dashboard.dtos.StudentRequestDTO;
import com.aat_projects.student_dashboard.dtos.StudentResponseDTO;
import com.aat_projects.student_dashboard.entity.Category;
import com.aat_projects.student_dashboard.entity.Student;
import com.aat_projects.student_dashboard.mapper.StudentMapper;
import com.aat_projects.student_dashboard.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {
    public final StudentRepository repository;

    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = repository.findAll();
        return students.stream().map(StudentMapper::toResponse).toList();
    }

    public void addStudent(StudentRequestDTO request) {
        double average = (request.getMath() + request.getPhysics()+ request.getComputer()+ request.getChemistry() + request.getEnglish()) / 5.0;

        double cgpa = average / 10.0;

        String category;
        if (cgpa >= 8) {
            category = "Excellent";
        } else if (cgpa >= 6) {
            category = "Good";
        } else {
            category = "Needs_Improvement";
        }

        String feedback = generateFeedback(request);
        Student student = Student.builder()
                .name(request.getName())
                .math(request.getMath())
                .physics(request.getPhysics())
                .computer(request.getComputer())
                .chemistry(request.getChemistry())
                .english(request.getEnglish())
                .cgpa(cgpa)
                .category(Category.valueOf(category))
                .feedback(feedback)
                .build();
        repository.save(student);

    }
    private static String generateFeedback(StudentRequestDTO requestDTO) {

        int max = requestDTO.getMath();

        if (requestDTO.getChemistry() > max) {
            max = requestDTO.getChemistry();
        }

        if (requestDTO.getPhysics() > max) {
            max = requestDTO.getPhysics();
        }

        if (requestDTO.getComputer() > max) {
            max = requestDTO.getComputer();
        }

        if (requestDTO.getEnglish() > max) {
            max = requestDTO.getEnglish();
        }

        if (max == requestDTO.getMath()) {
            return "Strong in Math";
        } else if (max == requestDTO.getChemistry()) {
            return "Strong in Chemistry";
        } else if (max == requestDTO.getPhysics()) {
            return "Strong in Physics";
        } else if (max == requestDTO.getComputer()) {
            return "Strong in Computer";
        } else {
            return "Strong in English";
        }
    }
}
