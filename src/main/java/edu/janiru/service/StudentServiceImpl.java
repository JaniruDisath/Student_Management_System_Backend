package edu.janiru.service;

import edu.janiru.model.dto.Student;
import edu.janiru.model.entity.StudentEntity;
import edu.janiru.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student user) {
        studentRepository.save(new StudentEntity(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getAddress()));
        return "User Added Successfully";
    }

    @Override
    public Student getStudent(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        return new Student(studentEntity.getId(), studentEntity.getName(), studentEntity.getEmail(), studentEntity.getPhone(), studentEntity.getAddress());
    }

    @Override
    public List<Student> getAllStudents() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntityList) {
            studentList.add(new Student(studentEntity.getId(),studentEntity.getName(),studentEntity.getEmail(),studentEntity.getPhone(),studentEntity.getAddress()));
        }
        return studentList;
    }

    @Override
    public String updateStudent(Long id, Student updateStudent) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);

        if (studentEntity == null) return null;

        studentEntity.setName(updateStudent.getName());
        studentEntity.setEmail(updateStudent.getEmail());
        studentEntity.setPhone(updateStudent.getPhone());
        studentEntity.setAddress(updateStudent.getAddress());

        studentRepository.save(studentEntity);

        return "User Updates Successfully ";
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "User Deleted Successfully";
    }
}
