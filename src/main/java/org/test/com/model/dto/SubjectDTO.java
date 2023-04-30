package org.test.com.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
public class SubjectDTO {
    private long id;
    private String subject;
    private List<StudentDTO> students;
}
