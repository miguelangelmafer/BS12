package com.bosonit.EJ3.Teacher.application.UseCase;

import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import com.bosonit.EJ3.Teacher.application.Port.GetTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.Repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetTeacherUseCase implements GetTeacherPort {
    @Autowired
    TeacherRepository teacherRepository;

    public TeacherEnt getTeacherByID(String id) throws Exception {
        return teacherRepository.findById(id).orElseThrow(()-> new Exception("Profesor no encontrado"));
    }

    public List<TeacherEnt> getAllTeacher() {
        List<TeacherEnt> teacherEntList = teacherRepository.findAll();
        return teacherEntList;
    }

    @Autowired
    ModelMapper modelMapper;

    public List<OutputStudentDTO> getProfessorStudents(String id) {

        //Buscamos que exista el profesor
        TeacherEnt teacherEnt = teacherRepository.findById(id).orElseThrow(() -> new NotFoundException("PROFESSOR NOT REGISTERED"));
       //Generamos un listado de los estudiantes que tiene asociado dicho profesor
        List<StudentEnt> studentEntList = teacherEnt.getStudents();
        //Generamos una lista de tipo Output
        List<OutputStudentDTO> listDTO = new ArrayList<>();

        //realizamos un lambda para asociar la lista de alumnos a la lista output
        studentEntList.forEach(student -> {
            OutputStudentDTO outputStudentDTO = modelMapper.map(student, OutputStudentDTO.class);
            //Asociamos el id de persona al output de salida del estudiante
            outputStudentDTO.setId_persona(student.getPersonaEnt().getId_persona());
            listDTO.add(outputStudentDTO);
        });
        return listDTO;
    }



}
