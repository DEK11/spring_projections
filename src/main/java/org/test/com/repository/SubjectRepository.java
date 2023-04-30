package org.test.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.test.com.model.Subject;
import org.test.com.model.dto.SubjectDTO;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value =
            "select sb.id as id, sb.subject as subject, st as students from subjects sb " +
            "join subjects_students ss on (sb.id = ss.subject_id) " +
            "join students st on (ss.student_id = st.id)", nativeQuery = true
    )
    List<SubjectDTO> findSubjectsAll();
}
