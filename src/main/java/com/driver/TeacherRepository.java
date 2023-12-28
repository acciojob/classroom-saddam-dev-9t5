package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherRepository {
    Map<String, Teacher> teacherList = new HashMap<>();
    TeacherStudentMapTableRepository teacherStudentMapTableRepository = new TeacherStudentMapTableRepository();
    public String addTeacher(Teacher teacher) {
        String name = teacher.getName();
        this.teacherList.put(name, teacher);
        return "New teacher added successfully";
    }

    public void updateStudentNumber(String name) {
        if(this.teacherList.containsKey(name)) {
            Teacher teacher = teacherList.get(name);
            int numberOfStudent = teacher.getNumberOfStudents();
            teacher.setNumberOfStudents(numberOfStudent+1);
            this.teacherList.put(name, teacher);
        }
    }

    public Teacher getTeacherByName(String name) {
        if(this.teacherList.containsKey(name)) {
            return this.teacherList.get(name);
        }
        return new Teacher();
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return teacherStudentMapTableRepository.getStudentsByTeacherName(teacher);
    }

    public String deleteTeacherByName(String teacher) {
        this.teacherList.remove(teacher);
        teacherStudentMapTableRepository.teacherStudentMapTable.remove(teacher);
        return " removed successfully";
    }

    public String deleteAllTeachers() {
        this.teacherList.clear();
        teacherStudentMapTableRepository.teacherStudentMapTable.clear();
        return "All teachers deleted successfully";
    }

    public List<String> getAllTeacher() {
        List<String> teachers = new ArrayList<>();
        for(Teacher teacher: teacherList.values()) {
            teachers.add(teacher.getName());
        }
        return teachers;
    }
}
