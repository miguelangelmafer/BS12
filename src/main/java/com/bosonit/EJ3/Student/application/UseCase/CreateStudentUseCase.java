package com.bosonit.EJ3.Student.application.UseCase;

import com.bosonit.EJ3.Student.application.Port.CreateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentUseCase implements CreateStudentPort {

    @Autowired
    StudentRepository studentRepository;

    public StudentEnt addStudent(StudentEnt studentEnt) {
            return studentRepository.save(studentEnt);}
}
