package edu.janiru.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
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
