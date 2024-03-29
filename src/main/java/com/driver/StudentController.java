package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {
    StudentService studentService = new StudentService();
    TeacherService teacherService = new TeacherService();

    TeacherStudentMapTableService teacherStudentMapTableService = new TeacherStudentMapTableService();

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        String response =  teacherService.addTeacher(teacher);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){
        String response = teacherStudentMapTableService.addStudentTeacherPair(student, teacher);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
        Student student = null; // Assign student by calling service layer method
        student = studentService.getStudentByName(name);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = null; // Assign student by calling service layer method
        teacher = teacherService.getTeacherByName(name);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = null; // Assign list of student by calling service layer method
        students = teacherService.getStudentsByTeacherName(teacher);
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = null; // Assign list of student by calling service layer method
        students = studentService.getAllStudent();
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        String response = teacherService.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + response, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){
        String response = teacherService.deleteAllTeachers();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/getAllTeacher")
    public ResponseEntity<List<String>> getAllTeacher(){
        List<String> data = null; // Assign list of student by calling service layer method
        data = teacherService.getAllTeacher();
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("/getStudentTeacherTable")
    public ResponseEntity<Map<String, ArrayList<String>>> getStudentTeacherTable(){
        Map<String, ArrayList<String>> data = null; // Assign list of student by calling service layer method
        data = teacherStudentMapTableService.getStudentTeacherTable();
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
