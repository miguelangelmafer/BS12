package com.bosonit.EJ3.Teacher.application.UseCase;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Teacher.application.Port.DeleteTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTeacherUseCase implements DeleteTeacherPort {
    @Autowired
    TeacherRepository teacherRepository;
    public void deleteTeacher(TeacherEnt teacherEnt) {
        teacherRepository.delete(teacherEnt);
    }
}
