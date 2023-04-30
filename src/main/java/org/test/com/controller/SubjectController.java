package org.test.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.com.model.Subject;
import org.test.com.model.dto.SubjectDTO;
import org.test.com.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api2")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>(subjectRepository.findAll());
        if (subjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/subjects2")
    public ResponseEntity<List<SubjectDTO>> getAllSubjectsDTO() {
        List<SubjectDTO> subjects = new ArrayList<>(subjectRepository.findSubjectsAll());
        if (subjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PostMapping("/subjects")
    public ResponseEntity<Subject> addStudent(@RequestBody Subject subject) {
        try {
            Subject _subject = subjectRepository.save(new Subject(subject.getSubject()));
            return new ResponseEntity<>(_subject, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
