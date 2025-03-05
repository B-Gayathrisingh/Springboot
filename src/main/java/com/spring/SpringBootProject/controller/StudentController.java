package com.spring.SpringBootProject.controller;

import com.spring.SpringBootProject.dto.StudentDto;
import com.spring.SpringBootProject.entity.Students;
import com.spring.SpringBootProject.service.StudentService;
import com.spring.SpringBootProject.service.impl.StudentServiceImpl;
import com.spring.SpringBootProject.service.impl.StudentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private Studentser studentService;

    @PostMapping("/student")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {

        StudentDto saveStudents = studentService.savestudent(studentDto);
        return new ResponseEntity<>(saveStudents, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable int id) {
        Students student = studentService.getstudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudents(
            @PathVariable int id,
            @RequestBody StudentDto studentDto) {
        StudentDto updatedStudents = studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(updatedStudents, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Students>deleteStudent(@PathVariable int id){
        Students students=studentService.deleteStudent(id);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

}