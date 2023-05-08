package org.test.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.com.model.Student;
import org.test.com.model.StudentSubject;
import org.test.com.model.Subject;
import org.test.com.model.dto.SubjectDTO;
import org.test.com.repository.StudentRepository;
import org.test.com.repository.StudentSubjectRepository;
import org.test.com.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentSubjectRepository studentSubjectRepository;

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
//        Set<StudentSubject> studentSubjects = subject.getStudentSubjects();
//        subject.setStudentSubjects(null);
        Subject _subject = subjectRepository.save(subject);
//        Set<StudentSubject> _studentSubjects = new HashSet<>();
//        for(StudentSubject studentSubject: studentSubjects) {
//            Student _student = studentRepository.save(studentSubject.getStudent());
//            studentSubject.setStudent(null);
//            StudentSubject _studentSubject = studentSubjectRepository.save(studentSubject);
//            _studentSubject.setStudent(_student);
//            _studentSubjects.add(_studentSubject);
//        }
//        _subject.setStudentSubjects(_studentSubjects);
//        Subject _subject = subjectRepository.save(new Subject(subject.getSubject()));
        return new ResponseEntity<>(_subject, HttpStatus.CREATED);
    }
}
