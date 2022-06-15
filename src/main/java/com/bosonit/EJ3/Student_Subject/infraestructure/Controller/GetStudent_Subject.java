package com.bosonit.EJ3.Student_Subject.infraestructure.Controller;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.OutPersonaDTO;
import com.bosonit.EJ3.Student_Subject.application.Port.GetStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class GetStudent_Subject {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    GetStudent_SubjectPort getStudent_subjectPort;

    @GetMapping("/id/{id}")
    public OutputStudent_SubjectDTO getSubjectByID(@PathVariable String id) throws Exception{
        Student_SubjectEnt student_subjectEnt = getStudent_subjectPort.getSubjectByID(id);
        OutputStudent_SubjectDTO outputStudent_subjectDTO = modelMapper.map(student_subjectEnt,OutputStudent_SubjectDTO.class);
        return outputStudent_subjectDTO;
    }

    @GetMapping("/all")
    public List<OutputStudent_SubjectDTO> getAllPerson(){
        List <Student_SubjectEnt> student_subjectEntList = getStudent_subjectPort.getAllSubject();
        TypeToken<List<OutputStudent_SubjectDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputStudent_SubjectDTO> outputStudent_subjectDTOList = modelMapper.map(student_subjectEntList, typeToken.getType());
        return outputStudent_subjectDTOList;
    }

    @GetMapping("/name/{subject}")
    public List<OutputStudent_SubjectDTO> getSubjectByName(@PathVariable String subject) throws Exception {
        List <Student_SubjectEnt> student_subjectEntList = getStudent_subjectPort.getSubjectByName(subject);
        TypeToken<List<OutputStudent_SubjectDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputStudent_SubjectDTO> outputStudent_subjectDTOList = modelMapper.map(student_subjectEntList, typeToken.getType());
        return outputStudent_subjectDTOList;
    }

    @GetMapping("/idstudent/{id}")
    public List<OutputStudent_SubjectDTO> getSubjectList(@PathVariable String id){
        return getStudent_subjectPort.getSubjectStudent(id);
    }

}
