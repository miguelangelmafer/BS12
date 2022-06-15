package com.bosonit.EJ3.Teacher.infraestructure.Controller;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import com.bosonit.EJ3.Teacher.application.Port.GetTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.OutputTeacherDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class GetTeacher {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GetTeacherPort getTeacherPort;

    @GetMapping("/id/{id}")
    public OutputTeacherDTO getTeacherByID(@PathVariable String id) throws Exception{
        return new OutputTeacherDTO(getTeacherPort.getTeacherByID(id));
    }

    @GetMapping("/all")
    public List<OutputTeacherDTO> getAllTeacher(){
        List <TeacherEnt> teacherEntList = getTeacherPort.getAllTeacher();
        TypeToken<List<OutputTeacherDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputTeacherDTO> outputTeacherDTOList = modelMapper.map(teacherEntList, typeToken.getType());
        return outputTeacherDTOList;
    }

    @GetMapping("/{id}/students")

    public List<OutputStudentDTO> getStudentsList(@PathVariable String id){

        return getTeacherPort.getProfessorStudents(id);
    }
}
