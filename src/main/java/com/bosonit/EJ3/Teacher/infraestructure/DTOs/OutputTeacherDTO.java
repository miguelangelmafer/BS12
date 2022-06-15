package com.bosonit.EJ3.Teacher.infraestructure.DTOs;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class OutputTeacherDTO {

        private String id_teacher;
        private Integer id_persona;
        private String comments;
        private String branch;

        public OutputTeacherDTO(TeacherEnt teacher) {
            setId_teacher(teacher.getId_teacher());
            setId_persona(teacher.getPersonaEnt().getId_persona());
            setComments(teacher.getComments());
            setBranch(teacher.getBranch());
        }
}
