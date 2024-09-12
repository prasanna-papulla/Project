package com.example.assignment.controllers;

import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.models.Student;
import com.example.assignment.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    private String sayHello(){
        return "Hello World";
    }

    @GetMapping(value = "/get-all")
    public Iterable<Student> getStudents() {
        return studentService.listAll();
    }

    // Add validation to the saveStudent method
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveStudent(@Valid @RequestBody Student students) {
        studentService.saveOrUpdate(students);
        return ResponseEntity.ok("Student saved with ID: " + students.getStudentId());
    }

    // Add validation to the update method
    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Student student, @PathVariable(name = "id") Long id) {
        student.setStudentId(id);
        studentService.saveOrUpdate(student);
        return ResponseEntity.ok("Student updated with ID: " + student.getStudentId());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        Student student = studentService.getStudentByID(id);
        if (student == null) {
            throw new ResourceNotFoundException("Student with ID " + id + " not found");
        }
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with ID: " + id + " deleted successfully");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable(name = "id") Long studentId) {
        Student student = studentService.getStudentByID(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("Student with ID " + studentId + " not found");
        }
        return ResponseEntity.ok(student);
    }

}
