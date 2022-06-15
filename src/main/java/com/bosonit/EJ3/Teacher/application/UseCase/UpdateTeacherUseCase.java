package com.bosonit.EJ3.Teacher.application.UseCase;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import com.bosonit.EJ3.Teacher.application.Port.UpdateTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.InputTeacherDTO;
import com.bosonit.EJ3.Teacher.infraestructure.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTeacherUseCase implements UpdateTeacherPort {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherEnt updateTeacher(TeacherEnt teacherOld, InputTeacherDTO teacherNew) {

        teacherOld.setBranch(teacherNew.getBranch());
        teacherOld.setComments(teacherNew.getComments());

        return teacherRepository.save(teacherOld);

    }
}
