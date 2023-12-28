package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class TeacherStudentMapTableService {
    TeacherStudentMapTableRepository teacherStudentMapTableRepository = new TeacherStudentMapTableRepository();
    TeacherRepository teacherRepository = new TeacherRepository();
    StudentRepository studentRepository = new StudentRepository();
    public String addStudentTeacherPair(String student, String teacher) {
        List<String> allTeacher = teacherRepository.getAllTeacher();
        List<String> allStudent = studentRepository.getAllStudent();
        if( allStudent.contains(student) && allTeacher.contains(teacher) ) {
            if(teacherStudentMapTableRepository.addStudentTeacherPair(student, teacher)) {
                teacherRepository.updateStudentNumber(teacher);
            }
            return "New student-teacher pair added successfully";
        }
        String message = "Student or Teacher not in our list";
        if(!allStudent.contains(student)) message = "Student is not in our list";
        else message = "Teacher is not in our list";
        return message;
    }

    public Map<String, ArrayList<String>> getStudentTeacherTable() {
        return teacherStudentMapTableRepository.getStudentTeacherTable();
    }
}
