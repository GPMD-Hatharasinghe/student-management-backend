package edu.icet.student_info.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student_info")

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String name;
    private Integer age;
    private Integer contact;
    private String gName;
    private String gAddress;
    private Integer gContact;

}
