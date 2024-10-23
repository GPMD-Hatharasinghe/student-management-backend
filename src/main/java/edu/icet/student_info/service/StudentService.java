package edu.icet.student_info.service;

import edu.icet.student_info.model.Student;

import java.util.List;


public interface StudentService {
    Student save(Student student) ;

    List<Student> read();

    void delete(Integer id);


    Student put(Student student, Integer id);
}
