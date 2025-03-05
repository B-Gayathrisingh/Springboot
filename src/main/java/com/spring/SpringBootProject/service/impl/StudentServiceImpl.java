package com.spring.SpringBootProject.service.impl;
import com.spring.SpringBootProject.dto.StudentDto;
import com.spring.SpringBootProject.entity.Students;
import com.spring.SpringBootProject.repository.StudentRepository;
import com.spring.SpringBootProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public StudentDto savestudent(StudentDto studentDto){

        Students student =new Students(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getDepartments()
        );
        Students savestudent=studentRepository.save(student);

        StudentDto studentDto1=new StudentDto(
                savestudent.getId(),
                savestudent.getName(),
                savestudent.getDepartment()

        );
        return studentDto1;
    }

    @Override
    public StudentDto updateStudent(int id, StudentDto studentDto) {
        Students existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id:" + id));

        existingStudent.setName(studentDto.getName());
        existingStudent.setDepartment(studentDto.getDepartments());

        Students updatedStudent = studentRepository.save(existingStudent);

        return new StudentDto(
                updatedStudent.getId(),
                updatedStudent.getName(),
                updatedStudent.getDepartment()
        );
    }


}


    public  Students getstudent(int id){
        Students student=studentRepository.findById(id);

        return student;
    }


    public Students deleteStudent(int id) {
        Students student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id:" + id));
        studentRepository.deleteById(id);
        return student;
    }


}