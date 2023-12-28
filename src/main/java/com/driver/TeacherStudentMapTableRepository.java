package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class TeacherStudentMapTableRepository {
    Map<String, ArrayList<String>> teacherStudentMapTable = new HashMap<>();
    TeacherRepository teacherRepository = new TeacherRepository();

    public String addStudentTeacherPair(String student, String teacher) {
        ArrayList<String> students = new ArrayList<>();
        if(teacherStudentMapTable.containsKey(teacher)) {
            students = teacherStudentMapTable.get(teacher);
            if(!students.contains(student)) {
                students.add(student);
                teacherStudentMapTable.put(teacher, students);
                teacherRepository.updateStudentNumber(teacher);
            }
        }else {
            students.add(student);
            teacherStudentMapTable.put(teacher, students);
        }
        return "New student-teacher pair added successfully";
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> students = new ArrayList<>();
        if(teacherStudentMapTable.containsKey(teacher)) {
            students = teacherStudentMapTable.get(teacher);
        }
        return students;
    }

    public Map<String, ArrayList<String>> getStudentTeacherTable() {
        return this.teacherStudentMapTable;
    }
}
