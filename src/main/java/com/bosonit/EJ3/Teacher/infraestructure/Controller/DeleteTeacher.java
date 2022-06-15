package com.bosonit.EJ3.Teacher.infraestructure.Controller;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Teacher.application.Port.DeleteTeacherPort;
import com.bosonit.EJ3.Teacher.application.Port.GetTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class DeleteTeacher {
    @Autowired
    GetTeacherPort getTeacherPort;

    @Autowired
    DeleteTeacherPort deleteTeacherPort;
    @DeleteMapping("/delete/{id}")

    public String deleteTeacher(@PathVariable String id) throws Exception {

        TeacherEnt teacherEnt = getTeacherPort.getTeacherByID(id);
        deleteTeacherPort.deleteTeacher(teacherEnt);
        return "Profesor eliminado";

    }
}
