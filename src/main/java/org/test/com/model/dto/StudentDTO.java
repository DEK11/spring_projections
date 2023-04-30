package org.test.com.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO {
    private long id;
    private String name;
    private String email;
}
