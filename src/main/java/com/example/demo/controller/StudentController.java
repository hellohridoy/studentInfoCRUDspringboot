package com.example.demo.controller;

import com.example.demo.entity.Student;

import com.example.demo.servies.StudentService;
import com.example.demo.dto.StudentDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@Valid @RequestBody StudentDto studentDto) {
        Student student = convertToEntity(studentDto);
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDto studentDto) {
        Student student = convertToEntity(studentDto);
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    private Student convertToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setContactNumber(studentDto.getContactNumber());
        student.setAddress(studentDto.getAddress());
        student.setGender(studentDto.getGender());
        student.setAge(studentDto.getAge());
        student.setNid(studentDto.getNid());
        student.setSscResult(studentDto.getSscResult());
        student.setHscResult(studentDto.getHscResult());
        student.setAdmissionStatus(studentDto.getAdmissionStatus());
        student.setCreatedAt(studentDto.getCreatedAt());
        student.setUpdatedAt(studentDto.getUpdatedAt());
        return student;
    }
}
