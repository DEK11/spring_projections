package org.test.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.test.com.model.Subject;
import org.test.com.model.dto.SubjectDTO;

import java.util.Set;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value =
            "select sb.id as id, sb.subject as subject, json_agg(row_to_json(st)) as students from subjects sb " +
            "left join subjects_students ss on (sb.id = ss.subject_id) " +
            "left join students st on (ss.student_id = st.id) " +
            "group by sb.id, sb.subject", nativeQuery = true
    )
    Set<SubjectDTO> findSubjectsAll();
}
