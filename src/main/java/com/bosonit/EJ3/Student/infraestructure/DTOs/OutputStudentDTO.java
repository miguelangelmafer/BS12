package com.bosonit.EJ3.Student.infraestructure.DTOs;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OutputStudentDTO  {

    private String id_student;
    private Integer id_persona;
    private Integer num_hours_week;
    private String comments;
    //private String id_teacher;
    private String branch;

    public OutputStudentDTO(StudentEnt student) {
        setId_student(student.getId_student());
        setId_persona(student.getPersonaEnt().getId_persona());
        setComments(student.getComments());
        setBranch(student.getBranch());
        setNum_hours_week(student.getNum_hours_week());
    }
}
