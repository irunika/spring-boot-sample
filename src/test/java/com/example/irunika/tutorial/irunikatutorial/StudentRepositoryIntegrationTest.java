package com.example.irunika.tutorial.irunikatutorial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void populateTable() {
        studentRepository.save(new Student(5, "x"));
        studentRepository.save(new Student(3, "a"));
        studentRepository.save(new Student(1, "z"));
    }

    @Test
    public void findAllByOrderByName_invokeWithData_successfullyInvoked() {

        List<Student> students = studentRepository.findAllByOrderByName();

        Assert.assertEquals(students.get(0).getId(), 3);
        Assert.assertEquals(students.get(1).getId(), 5);
        Assert.assertEquals(students.get(2).getId(), 1);
    }
}
