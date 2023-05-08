package org.test.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.com.model.StudentSubject;
import org.test.com.repository.StudentSubjectRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentSubjectController {

    @Autowired
    StudentSubjectRepository studentSubjectRepository;
    @GetMapping("/students_subjects")
    public ResponseEntity<List<StudentSubject>> getAllSubjectsDTO() {
        List<StudentSubject> subjects = new ArrayList<>(studentSubjectRepository.findAll());
        if (subjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
}
