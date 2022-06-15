package com.bosonit.EJ3.Teacher.infraestructure.Controller;

import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import com.bosonit.EJ3.Teacher.application.Port.CreateTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.InputTeacherDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class CreateTeacher {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CreateTeacherPort createTeacherPort;

    @Autowired
    PersonaRepository personaRepository;

    @PostMapping("/add")
    public InputTeacherDTO addTeacher(@RequestBody InputTeacherDTO inputTeacherDTO) {
        Optional<PersonaEnt> personaEnt = personaRepository.findById(inputTeacherDTO.getId_persona());
        if (personaEnt.isEmpty()) {
            throw new NotFoundException("El ID de persona indicado no existe");
        }
        PersonaEnt checker = personaRepository.findById(inputTeacherDTO.getId_persona()).orElseThrow(() -> new NotFoundException("PERSONAL DATA NOT FOUND"));
        if(checker.getStudentEnt() != null){
            throw new NotFoundException("El ID de persona indicado ya esta asociado a un estudiante");
        }
        if (checker.getTeacherEnt() == null) {
            TeacherEnt teacherEnt = (modelMapper.map(inputTeacherDTO, TeacherEnt.class));
            teacherEnt.setPersonaEnt(personaEnt.get());
            teacherEnt = createTeacherPort.addTeacher(teacherEnt);
            inputTeacherDTO.setId_teacher(teacherEnt.getId_teacher());
            return inputTeacherDTO;
        }else throw new NotFoundException("El ID de persona indicado ya está asociado a otro profesor");
    }
}
