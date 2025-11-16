package edu.janiru.repository;

import edu.janiru.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
