package org.test.com.model.dto;

import java.util.List;

public interface SubjectDTO {
    long getId();
    String getSubject();
    List<StudentDTO> getStudents();
}
