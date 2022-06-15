package com.bosonit.EJ3.Student.application.UseCase;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student.application.Port.DeleteStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCase implements DeleteStudentPort {

    @Autowired
    StudentRepository studentRepository;

    public void deleteStudent(StudentEnt studentEnt) {
        studentRepository.delete(studentEnt);
    }
}