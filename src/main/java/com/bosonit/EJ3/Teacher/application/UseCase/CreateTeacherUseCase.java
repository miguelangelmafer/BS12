package com.bosonit.EJ3.Teacher.application.UseCase;


import com.bosonit.EJ3.Teacher.application.Port.CreateTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTeacherUseCase implements CreateTeacherPort {
    @Autowired
    TeacherRepository teacherRepository;

    public TeacherEnt addTeacher(TeacherEnt teacherEnt){
       return teacherRepository.save(teacherEnt);
    }
}
