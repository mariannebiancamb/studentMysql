package com.sortedstudant.controller;

import com.sortedstudant.dto.StudentDTO;
import com.sortedstudant.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<List<String>> sorted(@RequestBody StudentDTO student){
        studentService.addStudent(student);
        return ResponseEntity.ok(studentService.sortedStudent());
    }

}
