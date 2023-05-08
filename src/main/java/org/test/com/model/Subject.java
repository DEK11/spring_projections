package org.test.com.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    public Subject(){
    }

    public Subject(String subject) {
        this.subject = subject;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "subject_generator")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name = "subject")
    String subject;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Set<StudentSubject> studentSubjects = new HashSet<>();

    public Set<StudentSubject> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(Set<StudentSubject> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}
