package com.bosonit.EJ3.Student_Subject.application.UseCase;

import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import com.bosonit.EJ3.Student_Subject.application.Port.GetStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;
import com.bosonit.EJ3.Student_Subject.infraestructure.Repository.Student_SubjectRepository;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetStudent_SubjectUseCase implements GetStudent_SubjectPort {
    @Autowired
    Student_SubjectRepository student_subjectRepository;

    public Student_SubjectEnt getSubjectByID(String id) throws Exception {
        return student_subjectRepository.findById(id).orElseThrow(() -> new NotFoundException("Asignatura no encontrada"));
    }

    public List<Student_SubjectEnt> getAllSubject() {
        List<Student_SubjectEnt> student_subjectEntList = student_subjectRepository.findAll();
        return student_subjectEntList;
    }

    public List <Student_SubjectEnt> getSubjectByName(String subject){
        List <Student_SubjectEnt> student_subjectEntList = student_subjectRepository.findBySubject(subject);
        return student_subjectEntList;
    }

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;
    public List<OutputStudent_SubjectDTO> getSubjectStudent(String id) {

        //Buscamos que exista el alumno
        StudentEnt studentEnt = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("STUDENT NOT REGISTERED"));
        //Generamos un listado de las asignaturas que tiene asociado dicho estudiante
        List<Student_SubjectEnt> student_subjectEntList = studentEnt.getSubjects();
        //Generamos una lista de tipo Output
        List<OutputStudent_SubjectDTO> listDTO = new ArrayList<>();

        //realizamos un lambda para asociar la lista de asignaturas a la lista output
        student_subjectEntList.forEach(subject -> {
            OutputStudent_SubjectDTO outputStudent_subjectDTO = modelMapper.map(subject, OutputStudent_SubjectDTO.class);
            //Asociamos el id de persona al output de salida del estudiante
            listDTO.add(outputStudent_subjectDTO);
        });
        return listDTO;
    }

}
