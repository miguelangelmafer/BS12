package com.bosonit.EJ3.Teacher.application.Port;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;

import java.util.List;

public interface GetTeacherPort {

    public TeacherEnt getTeacherByID(String id) throws Exception;

    public List<TeacherEnt> getAllTeacher();

    public List<OutputStudentDTO> getProfessorStudents(String id);
}
