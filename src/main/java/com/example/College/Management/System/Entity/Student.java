package com.example.College.Management.System.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JsonBackReference // Prevent circular reference, avoid serializing professor again
    private Professor professor;  // This field corresponds to the mappedBy in Professor

    @ManyToMany
    @JsonBackReference // Prevent circular reference in the other side of the relationship
    private List<Subject> subjects;

    @OneToOne(mappedBy = "student")
    @JsonManagedReference // Used here because it's on the "other" side of the relationship
    private AdmissionRecord admissionRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public AdmissionRecord getAdmissionRecord() {
        return admissionRecord;
    }

    public void setAdmissionRecord(AdmissionRecord admissionRecord) {
        this.admissionRecord = admissionRecord;
    }
}
