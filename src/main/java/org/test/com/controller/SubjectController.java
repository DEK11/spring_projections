package org.test.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.com.model.StudentSubject;
import org.test.com.model.Subject;
import org.test.com.model.dto.SubjectDTO;
import org.test.com.repository.StudentRepository;
import org.test.com.repository.StudentSubjectRepository;
import org.test.com.repository.SubjectRepository;

import java.util.*;

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
        /**
         * Works with input
         * {
         *     "subject": "new_course",
         *     "studentSubjects": [
         *         {
         *             "random_string": "one2theree",
         *             "student_id": 4
         *         }
         *     ]
         * }
         * **/
        Subject _subject = subjectRepository.findSubjectByName(subject.getSubject());
        if (_subject == null) {
            _subject = new Subject();
            _subject.setId(subject.getId());
        }
        _subject.setSubject(subject.getSubject());
        _subject = subjectRepository.save(_subject);

        Set<StudentSubject> studentSubjects = subject.getStudentSubjects();
        if (studentSubjects != null) {
            Set<StudentSubject> _studentSubjects = new HashSet<>();
            for(StudentSubject studentSubject: studentSubjects) {
                StudentSubject _studentSubject = studentSubjectRepository.findStudentSubjectLink(
                        _subject.getId(),
                        studentSubject.getStudent_id()
                );
                if(_studentSubject == null) {
                    _studentSubject = new StudentSubject();
                    _studentSubject.setId(studentSubject.getId());
                    _studentSubject.setSubject_id(_subject.getId());
                    _studentSubject.setStudent_id(studentSubject.getStudent_id());
                }
                _studentSubject.setRandom_string(studentSubject.getRandom_string());
                _studentSubjects.add(_studentSubject);
            }
            _subject.setStudentSubjects(_studentSubjects);
        }
        return new ResponseEntity<>(subjectRepository.save(_subject), HttpStatus.CREATED);
    }
}
