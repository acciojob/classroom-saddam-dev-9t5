package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    TeacherRepository teacherRepository = new TeacherRepository();

    public String addTeacher(Teacher teacher) {
        return String.valueOf(teacherRepository.addTeacher(teacher));
    }

    public Teacher getTeacherByName(String name) {
        return teacherRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return teacherRepository.getStudentsByTeacherName(teacher);
    }

    public String deleteTeacherByName(String teacher) {
        return teacherRepository.deleteTeacherByName(teacher);
    }

    public String deleteAllTeachers() {
        return teacherRepository.deleteAllTeachers();
    }
    public List<String> getAllTeacher() {
        return teacherRepository.getAllTeacher();
    }
}
