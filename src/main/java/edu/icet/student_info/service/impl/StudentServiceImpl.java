package edu.icet.student_info.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.student_info.entity.StudentEntity;
import edu.icet.student_info.model.Student;
import edu.icet.student_info.repository.StudentRepository;
import edu.icet.student_info.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repo;
    @Autowired
    ObjectMapper mapper;


    public Student save(Student student) {
        StudentEntity entity = mapper.convertValue(
                student, StudentEntity.class);
        repo.save(entity);

        return mapper.convertValue(entity, Student.class);
    }

    public List<Student> read() {
        Iterable<StudentEntity> studentList = repo.findAll();
        List<Student> studentModel = new ArrayList<>();
        studentList.forEach(studentEntity ->
                studentModel.add(mapper.convertValue(studentEntity, Student.class))

        );
        return studentModel;
    }

    public void delete(Integer id) {
        Optional<StudentEntity> byId = repo.findById(id);
        repo.deleteById(id);


    }

    @Override
    public Student put(Student student, Integer id) {
        StudentEntity byId = repo.findById(id).orElse(null);


        StudentEntity entity = mapper.convertValue(
                student, StudentEntity.class);
        BeanUtils.copyProperties(entity, byId, "id");
        StudentEntity updatedEntity = repo.save(byId);

        return mapper.convertValue(updatedEntity, Student.class);
    }
}
