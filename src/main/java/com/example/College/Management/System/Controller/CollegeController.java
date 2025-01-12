package com.example.College.Management.System.Controller;

import com.example.College.Management.System.Entity.Professor;
import com.example.College.Management.System.Entity.Student;
import com.example.College.Management.System.Entity.Subject;
import com.example.College.Management.System.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

//  Professor endpoints
    @GetMapping("/professors")
    public List<Professor> getAllProfessors(){
        return collegeService.getAllProfessors();
    }

    @PostMapping("/professors")
    public Professor createProfessor(@RequestBody Professor professor){
        return collegeService.createProfessor(professor);
    }
//  Student endpoints
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return collegeService.getAllStudents();
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return collegeService.createStudent(student);
    }
//   Subject endpoints
    @GetMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return collegeService.getAllSubjects();
    }

    @PostMapping("/subjects")
    public Subject createSubjects(@RequestBody Subject subject){
        return collegeService.createSubjects(subject);
    }

    // Assignment endpoints
    @PostMapping("/assign/student/{studentId}/professor/{professorId}")
    public ResponseEntity<?>  assignStudentToProfessor(@PathVariable Long studentId,@PathVariable Long professorId){
        Student student= collegeService.assignStudentToProfessor(studentId,professorId);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/assign/subject/{subjectId}/professor/{professorId}")
    public ResponseEntity<?> assignSubjectToProfessor(@PathVariable Long subjectId,@PathVariable Long professorId){
        Subject subject=collegeService.assignSubjectToProfessor(subjectId,professorId);
        return ResponseEntity.ok(subject);
    }

}
