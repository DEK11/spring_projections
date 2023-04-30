package org.test.com.controller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.com.model.Student;
import org.test.com.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = new ArrayList<>(studentRepository.findAll());
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            Student _student = studentRepository.save(new Student(student.getName(), student.getEmail()));
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/generate/{id}")
    public ResponseEntity<List<Student>> generateStudents(@PathVariable int id) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < id; i++) {
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();
            students.add(studentRepository.save(new Student(name, email)));
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
