package org.test.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.test.com.model.StudentSubject;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {

    @Query("SELECT s FROM StudentSubject s WHERE s.subject_id =:subject_id and s.student_id =:student_id")
    StudentSubject findStudentSubjectLink(@Param("subject_id") long subject_id, @Param("student_id") long student_id);
}
