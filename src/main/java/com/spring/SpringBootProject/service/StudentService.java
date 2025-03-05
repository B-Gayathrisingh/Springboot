package com.spring.SpringBootProject.service;

import com.spring.SpringBootProject.dto.StudentDto;

public interface StudentService {
    StudentDto savestudent(StudentDto studentDto);



    StudentDto updateStudent(int id, StudentDto studentDto);
}
