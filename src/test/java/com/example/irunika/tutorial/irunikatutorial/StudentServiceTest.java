package com.example.irunika.tutorial.irunikatutorial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @MockBean
    private StudentRepository studentRepository;

    @TestConfiguration
    static class TestConfig {

        @Bean
        public StudentService studentService() {
            return new StudentService();
        }
    }

    @Autowired
    private StudentService studentService;

    @Before
    public void setup() {

        Mockito.when(studentRepository.findAllByOrderByName()).thenReturn(
                Stream.of(
                        new Student(1, "a"),
                        new Student(2, "b")
                ).collect(Collectors.toList())
        );
    }

    @Test
    public void test1() {
        List<Student> students = studentService.getStudentsSortedByName();
        Assert.assertEquals(students.get(0).getId(), 1);
    }

}
