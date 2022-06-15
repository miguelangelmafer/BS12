package com.bosonit.EJ3.Student.infraestructure.DTOs;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import lombok.Data;

@Data
public class InputStudentDTO {

    private String id_student;
    private Integer id_persona;
    private Integer num_hours_week;
    private String comments;
    private String id_teacher;
    private String branch;
}
