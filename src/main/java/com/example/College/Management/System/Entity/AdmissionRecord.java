package com.example.College.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AdmissionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String admissionDate;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;  // "student" is referenced here

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
