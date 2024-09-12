package com.example.assignment.services;


import com.example.assignment.models.Student;
import com.example.assignment.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Iterable<Student> listAll() {

        return this.studentRepository.findAll();
    }

    public void saveOrUpdate(Student students) {

        studentRepository.save(students);
    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    public Student getStudentByID(Long studentId) {

        return studentRepository.findById(studentId).get();
    }
}
