package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class StudentRepository {
    Map<String, Student> studentsList = new HashMap<>();

    public String addStudent(Student student) {
        String name = student.getName();
        studentsList.put(name, student);
        return "New student added successfully";
    }

    public Student getStudentByName(String name) {
        if(studentsList.containsKey(name)) {
            return studentsList.get(name);
        }
        return new Student();
    }

    public List<String> getAllStudent() {
        List<String> students = new ArrayList<>();
        for (Student student: studentsList.values()) {
            students.add(student.getName());
        }
        return students;
    }


}
