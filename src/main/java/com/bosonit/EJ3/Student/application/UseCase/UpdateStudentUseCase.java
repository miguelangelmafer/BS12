package com.bosonit.EJ3.Student.application.UseCase;

import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import com.bosonit.EJ3.Student.application.Port.UpdateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;
import com.bosonit.EJ3.Student_Subject.infraestructure.Repository.Student_SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateStudentUseCase implements UpdateStudentPort {

    @Autowired
    StudentRepository studentRepository;

    public StudentEnt updateStudent(StudentEnt studentOld, InputStudentDTO studentNew) {

        studentOld.setBranch(studentNew.getBranch());
        studentOld.setComments(studentNew.getComments());
        studentOld.setNum_hours_week(studentNew.getNum_hours_week());

        return studentRepository.save(studentOld);
    }

    @Autowired
    Student_SubjectRepository student_subjectRepository;

    @Autowired
    ModelMapper modelMapper;
    public List<OutputStudent_SubjectDTO> addSubjectList (String id, List<String> idSubjects) throws Exception {

        //Buscamos el alumno al que queremos añadir las asignaturas
        StudentEnt studentEnt = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("STUDENT NOT FOUND"));
        List<Student_SubjectEnt> subjectList = new ArrayList<>();

        idSubjects.forEach(subjectID -> {
            Student_SubjectEnt subject = student_subjectRepository.findById(subjectID).orElseThrow(() -> new NotFoundException("WRONG SUBJECT ID IN: " + subjectID));
            subjectList.add(subject);

        });
//REVISAR CODIGO
        // comprobamos que cada asignatura no este asignada al alumno.
        subjectList.forEach(subject -> {
            if (!studentEnt.getSubjects().contains(subject)) {
                studentEnt.getSubjects().add(subject);
                studentRepository.save(studentEnt);}
        });

        List<OutputStudent_SubjectDTO> subjectListOutputDTO = new ArrayList<>();
        subjectList.forEach(subject -> {
            OutputStudent_SubjectDTO subjectOutputDTO = modelMapper.map(subject, OutputStudent_SubjectDTO.class );
            subjectListOutputDTO.add(subjectOutputDTO);
        });

        return subjectListOutputDTO;
    }


    public List<OutputStudent_SubjectDTO> deleteSubjectList (String id, List<String> idSubjects) throws Exception {

        //Buscamos el alumno al que queremos añadir las asignaturas
        StudentEnt studentEnt = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("STUDENT NOT FOUND"));
        List<Student_SubjectEnt> subjectList = new ArrayList<>();

        idSubjects.forEach(subjectID -> {
            Student_SubjectEnt subject = student_subjectRepository.findById(subjectID).orElseThrow(() -> new NotFoundException("WRONG SUBJECT ID IN: " + subjectID));
            subjectList.add(subject);

        });
//REVISAR CODIGO
        // comprobamos que cada asignatura  este asignada al alumno.
        subjectList.forEach(subject -> {
            if (studentEnt.getSubjects().contains(subject)) {
                studentEnt.getSubjects().remove(subject);
                studentRepository.save(studentEnt);}
        });

        List<OutputStudent_SubjectDTO> subjectListOutputDTO = new ArrayList<>();
        subjectList.forEach(subject -> {
            OutputStudent_SubjectDTO subjectOutputDTO = modelMapper.map(subject, OutputStudent_SubjectDTO.class );
            subjectListOutputDTO.add(subjectOutputDTO);
        });

        return subjectListOutputDTO;
    }


}