package org.test.com.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "subjects_students")
public class StudentSubject {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(long subject_id) {
        this.subject_id = subject_id;
    }

//    public long getStudent_id() {
//        return student_id;
//    }
//
//    public void setStudent_id(long student_id) {
//        this.student_id = student_id;
//    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getRandom_string() {
        return random_string;
    }

    public void setRandom_string(String random_string) {
        this.random_string = random_string;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "subject_student_generator")
    private long id;

    @Column(name="subject_id")
    private long subject_id;

//    @Column(name="student_id")
//    private long student_id;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Date updated_at;

    @Column(name="created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name="random_string")
    private String random_string;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private Student student;
}
