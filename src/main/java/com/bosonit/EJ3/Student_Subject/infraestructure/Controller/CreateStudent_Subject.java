package com.bosonit.EJ3.Student_Subject.infraestructure.Controller;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student.application.Port.GetStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.Controller.GetStudent;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import com.bosonit.EJ3.Student_Subject.application.Port.CreateStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.InputStudent_SubjectDTO;
import org.hibernate.mapping.Array;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class CreateStudent_Subject {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CreateStudent_SubjectPort createStudent_subjectPort;
    @Autowired
    GetStudentPort getStudentPort;


@PostMapping("/add")
    public InputStudent_SubjectDTO addSubject(@RequestBody InputStudent_SubjectDTO inputStudent_subjectDTO) throws Exception{
        Student_SubjectEnt student_subjectEnt = createStudent_subjectPort.addSubject(modelMapper.map(inputStudent_subjectDTO, Student_SubjectEnt.class));
        inputStudent_subjectDTO.setId_subject(student_subjectEnt.getId_subject());
        // añadir id estudiantes a la lista
    StudentEnt student =getStudentPort.getStudentByID(inputStudent_subjectDTO.getId_student());
        student_subjectEnt.getStudents().add(student);
        return inputStudent_subjectDTO;
    }
}
