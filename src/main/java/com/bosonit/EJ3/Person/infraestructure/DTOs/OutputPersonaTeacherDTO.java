package com.bosonit.EJ3.Person.infraestructure.DTOs;

import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.OutputTeacherDTO;
import lombok.Data;

@Data
public class OutputPersonaTeacherDTO extends OutPersonaDTO{
    private OutputTeacherDTO teacherEnt;
}
