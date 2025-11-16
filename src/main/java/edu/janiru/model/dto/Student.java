package edu.janiru.model.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
