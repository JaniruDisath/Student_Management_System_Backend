package edu.janiru.service;

import edu.janiru.model.dto.Student;

import java.util.List;

public interface StudentService {

    String saveStudent(Student student);
    Student getStudent(Long id);
    List<Student> getAllStudents();
    String updateStudent(Long id, Student user);
    String deleteStudent(Long id);
}
