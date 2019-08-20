package com.example.irunika.tutorial.irunikatutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return studentService.getHelloStr();
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getStudents(@RequestParam boolean sorted) {
        if (sorted) {
            return studentService.getStudentsSortedByName();
        }
        return studentService.getStudents();
    }

}
