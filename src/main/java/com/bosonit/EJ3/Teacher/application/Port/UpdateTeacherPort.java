package com.bosonit.EJ3.Teacher.application.Port;

import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.InputTeacherDTO;

public interface UpdateTeacherPort {

    public TeacherEnt updateTeacher(TeacherEnt teacherOld, InputTeacherDTO teacherNew);
}
