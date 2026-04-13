package com.aat_projects.student_dashboard.repository;

import com.aat_projects.student_dashboard.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}