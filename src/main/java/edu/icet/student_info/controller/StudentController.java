package edu.icet.student_info.controller;

import edu.icet.student_info.model.Student;
import edu.icet.student_info.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private  final StudentService studentService;

    @PostMapping("/student")
    Student save(@RequestBody Student student){

        return studentService.save(student);
    }

    @GetMapping("/student")
    List<Student> retrive(){
        return studentService.read();
    }

    @DeleteMapping("/student/{id}")
    void delete(@PathVariable Integer id){

       studentService.delete(id);
    }

    @PutMapping("/student/{id}")
    Student update(@RequestBody Student student,  @PathVariable Integer id) {

        return studentService.put(student, id);
    }




}
