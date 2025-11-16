package edu.janiru.controller;


import edu.janiru.model.dto.Student;
import edu.janiru.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
//@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired StudentService studentService;


    // CREATE
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentService.saveStudent(student);
    }

    // READ (single)
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    // READ (all)
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Student Student) {
        return studentService.updateStudent(id, Student);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
    
}
