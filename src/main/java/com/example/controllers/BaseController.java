package com.example.controllers;

package dev.vorstu.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vorstu.dto.Student;
import dev.vorstu.repositories.StudentRepository;

@RestController
@RequestMapping("api/base")
public class BaseController {

    @Autowired
    private StudentRepository studentRepository;

    private Long counter = 0L;

    private Long generateId() {
        return counter++;
    }

    List<Student> students;

    @PostConstruct
    private void ini() {
        students = new ArrayList();
        students.add(new Student(generateId(),"Ivan1", "VM", "+7"));
        students.add(new Student(generateId(),"Ivan2", "VM", "+8"));
        students.add(new Student(generateId(),"Ivan3", "AM", "+9"));
    }

    @GetMapping("check")
    public String getAllUsers() {
        return "Hello world " + new Date();
    }

    @GetMapping("students")
    public List getAllStudents() {
        return students;
    }

    @PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student newStudent) {
        return addStudent(newStudent);
    }

    private Student addStudent(Student student) {
        student.setId(generateId());
        students.add(student);
        return student;
    }

    @PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student changeStudent(@RequestBody Student changingStudent) {
        return updateStudent(changingStudent);
    }

    private Student updateStudent(Student student) {
        if (student.getId()==null)
        {
            throw new RuntimeException("id of changing student cannot be null");
        }
        Student changingStudent = students.stream()
                .filter(el -> el.getId().equals(student.getId()))
                .findFirst().orElseThrow(() -> new RuntimeException("student with id:" + student.getId() + "not found"));
        changingStudent.setFio(student.getFio());
        changingStudent.setGroup(student.getGroup());
        changingStudent.setPhoneNumber(student.getPhoneNumber());

        return student;
    }

    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteStudent(@PathVariable("id")Long id) {
        return remoteStudent(id);
        //studentRepository.deleteById(id);
    }

    private Long remoteStudent(Long id) {
        students.removeIf(el -> el.getId().equals(id));
        return id;
    }
}
