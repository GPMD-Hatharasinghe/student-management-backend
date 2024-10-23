package edu.icet.student_info.repository;

import edu.icet.student_info.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {

}
