package com.bosonit.EJ3.Student.infraestructure.Controller;

import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student.application.Port.CreateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.Repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping ("/student")
public class CreateStudent {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CreateStudentPort createStudentPort;
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @PostMapping("/add")
    public InputStudentDTO addStudent(@RequestBody InputStudentDTO inputStudentDTO){
        Optional<PersonaEnt> personaEnt=personaRepository.findById(inputStudentDTO.getId_persona());
        if(personaEnt.isEmpty()){
            throw new NotFoundException("El ID de persona indicado no existe");
        }
        Optional<TeacherEnt> teacherEnt=teacherRepository.findById(inputStudentDTO.getId_teacher());
        if(teacherEnt.isEmpty()){
            throw new NotFoundException("El ID de profesor indicado no existe");
        }
        PersonaEnt checker = personaRepository.findById(inputStudentDTO.getId_persona()).orElseThrow(() -> new NotFoundException("PERSONAL DATA NOT FOUND"));
        if(checker.getTeacherEnt() != null){
            throw new NotFoundException("El ID de persona indicado ya esta asociado a un profesor");
        }
        if (checker.getStudentEnt() == null ) {

        StudentEnt studentEnt =(modelMapper.map(inputStudentDTO, StudentEnt.class));
        studentEnt.setPersonaEnt(personaEnt.get());
        studentEnt.setMy_teacher(teacherEnt.get());
        studentEnt = createStudentPort.addStudent(studentEnt);
        inputStudentDTO.setId_student(studentEnt.getId_student());
        return inputStudentDTO;
        //mejorar este mensaje
     }else throw new NotFoundException("El Id de persona indicado ya está asociado a otro estudiante");
    }
}
