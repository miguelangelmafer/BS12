package com.bosonit.EJ3.Teacher.application.Port;

import com.bosonit.EJ3.Teacher.domain.TeacherEnt;

public interface CreateTeacherPort {
    public TeacherEnt addTeacher(TeacherEnt teacherEnt);
}
