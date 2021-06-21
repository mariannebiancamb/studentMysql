package com.sortedstudant.service;

import com.sortedstudant.dto.StudentDTO;
import com.sortedstudant.entity.Student;
import com.sortedstudant.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(StudentDTO studentDTO){
        List<String> student = studentDTO.getName();

        for (int i = 0; i < student.size(); i++) {
            studentRepository.save(Student.builder()
                    .name(student.get(i))
                    .build());
        }
    }

    public List<String> sortedStudent(){
        List<String> students = new ArrayList<>();
        ThreadLocalRandom.current().ints(1, 21).distinct().limit(10)
                .forEach(p -> students.add(studentRepository.findById((long) p).get().getName()));

        return students;
    }
}
