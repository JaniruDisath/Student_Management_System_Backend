package edu.janiru.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Integer grade;
    private Integer year;
    private LocalDate enteredYear;
    private LocalDate dob;
    private String subjectStream;
    private String studentClass;
    private String medium;
    private String email;
    private String phone;
    private String address;
}
