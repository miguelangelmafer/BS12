package com.bosonit.EJ3.Teacher.infraestructure.Controller;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Teacher.application.Port.GetTeacherPort;
import com.bosonit.EJ3.Teacher.application.Port.UpdateTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.InputTeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class UpdateTeacher {
    @Autowired
    GetTeacherPort getTeacherPort;

    @Autowired
    UpdateTeacherPort updateTeacherPort;

    @PutMapping("/update/{id}")
    public TeacherEnt updateTeacher(@PathVariable String id, @RequestBody InputTeacherDTO inputTeacherDTO) throws Exception{
        TeacherEnt teacherEnt = getTeacherPort.getTeacherByID(id);
        updateTeacherPort.updateTeacher(teacherEnt,inputTeacherDTO);
        return teacherEnt;
    }
}
