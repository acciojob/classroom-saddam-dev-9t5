package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    StudentRepository studentRepository = new StudentRepository();

    public String addStudent(Student student) {
        return String.valueOf(studentRepository.addStudent(student));
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public List<String> getAllStudent() {
        return studentRepository.getAllStudent();
    }

}
