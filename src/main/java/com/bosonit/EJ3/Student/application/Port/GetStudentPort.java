package com.bosonit.EJ3.Student.application.Port;

import com.bosonit.EJ3.Student.domain.StudentEnt;

import java.util.List;

public interface GetStudentPort {
    public StudentEnt getStudentByID(String id) throws Exception;

    public List<StudentEnt> getAllStudent();
}
