package org.test.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.com.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
