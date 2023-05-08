package org.test.com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    public Student() {
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "students_generator")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
