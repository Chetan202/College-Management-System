package com.example.College.Management.System.Service;

import com.example.College.Management.System.Entity.Professor;
import com.example.College.Management.System.Entity.Student;
import com.example.College.Management.System.Entity.Subject;
import com.example.College.Management.System.Repository.ProfessorRepository;
import com.example.College.Management.System.Repository.StudentRepository;
import com.example.College.Management.System.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public CollegeService(ProfessorRepository professorRepository,
                          StudentRepository studentRepository,
                          SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject createSubjects(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Student assignStudentToProfessor(Long studentId, Long professorId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        student.setProfessor(professor);
        return studentRepository.save(student);
    }

    public Subject assignSubjectToProfessor(Long subjectId, Long professorId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        subject.setProfessor(professor);
        return subjectRepository.save(subject);
    }
}
