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
    public String saveStudent(Student student) {
        studentRepository.save(
                new StudentEntity(
                        student.getId(),
                        student.getFullName(),
                        student.getGrade(),
                        student.getYear(),
                        student.getEnteredYear(),
                        student.getDob(),
                        student.getSubjectStream(),
                        student.getStudentClass(),
                        student.getMedium(),
                        student.getEmail(),
                        student.getPhone(),
                        student.getAddress()));
        return "User Added Successfully";
    }

    @Override
    public Student getStudent(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        return new Student(
                studentEntity.getId(),
                studentEntity.getFullName(),
                studentEntity.getGrade(),
                studentEntity.getYear(),
                studentEntity.getEnteredYear(),
                studentEntity.getDob(),
                studentEntity.getSubjectStream(),
                studentEntity.getStudentClass(),
                studentEntity.getMedium(),
                studentEntity.getEmail(),
                studentEntity.getPhone(),
                studentEntity.getAddress()
        );
    }

    @Override
    public List<Student> getAllStudents() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntityList) {
            studentList.add(new Student(
                            studentEntity.getId(),
                            studentEntity.getFullName(),
                            studentEntity.getGrade(),
                            studentEntity.getYear(),
                            studentEntity.getEnteredYear(),
                            studentEntity.getDob(),
                            studentEntity.getSubjectStream(),
                            studentEntity.getStudentClass(),
                            studentEntity.getMedium(),
                            studentEntity.getEmail(),
                            studentEntity.getPhone(),
                            studentEntity.getAddress()
                    )
            );
        }
        return studentList;
    }

    @Override
    public String updateStudent(Long id, Student updateStudent) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);

        if (studentEntity == null) return null;

        studentEntity.setFullName(updateStudent.getFullName());
        studentEntity.setGrade(updateStudent.getGrade());
        studentEntity.setYear(updateStudent.getYear());
        studentEntity.setEnteredYear(updateStudent.getEnteredYear());
        studentEntity.setDob(updateStudent.getDob());
        studentEntity.setSubjectStream(updateStudent.getSubjectStream());
        studentEntity.setStudentClass(updateStudent.getStudentClass());
        studentEntity.setMedium(updateStudent.getMedium());
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
