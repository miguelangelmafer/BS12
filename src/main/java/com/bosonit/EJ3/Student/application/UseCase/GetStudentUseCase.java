package com.bosonit.EJ3.Student.application.UseCase;


import com.bosonit.EJ3.Student.application.Port.GetStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStudentUseCase implements GetStudentPort {

    @Autowired
    StudentRepository studentRepository;

    public StudentEnt getStudentByID(String id) throws Exception
    {
       return studentRepository.findById(id).orElseThrow(()-> new Exception("Usuario no encontrado"));
    }

    public List<StudentEnt> getAllStudent() {
        List<StudentEnt> studentEntList = studentRepository.findAll();
        return studentEntList;
    }
}
