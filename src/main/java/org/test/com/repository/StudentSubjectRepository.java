package org.test.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.com.model.StudentSubject;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {
}
