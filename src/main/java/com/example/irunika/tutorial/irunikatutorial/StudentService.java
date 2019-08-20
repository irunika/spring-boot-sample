package com.example.irunika.tutorial.irunikatutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String getHelloStr() {
        return "hello str";
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsSortedByName() {
        return studentRepository.findAllByOrderByName();
    }

}
