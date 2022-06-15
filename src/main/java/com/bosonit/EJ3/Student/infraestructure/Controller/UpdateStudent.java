package com.bosonit.EJ3.Student.infraestructure.Controller;

import com.bosonit.EJ3.Person.Exceptions.UnprocesableException;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ3.Student.application.Port.GetStudentPort;
import com.bosonit.EJ3.Student.application.Port.UpdateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class UpdateStudent {

    @Autowired
    GetStudentPort getStudentPort;

    @Autowired
    UpdateStudentPort updateStudentPort;

    @PutMapping("/update/{id}")
    public StudentEnt updateStudent(@PathVariable String id, @RequestBody InputStudentDTO inputStudentDTO) throws Exception{
        StudentEnt studentEnt = getStudentPort.getStudentByID(id);
        updateStudentPort.updateStudent(studentEnt,inputStudentDTO);
        return studentEnt;
    }
    @PutMapping("/student/{id}/addSubjectList")
    public List<OutputStudent_SubjectDTO> addSubjects(@PathVariable("id") String id, @RequestBody List<String> idSubjects) throws Exception {

        return updateStudentPort.addSubjectList(id, idSubjects);
    }

    @PutMapping("/student/{id}/deleteSubjectList")
    public List<OutputStudent_SubjectDTO> deleteSubjects(@PathVariable("id") String id, @RequestBody List<String> idSubjects) throws Exception {

        return updateStudentPort.deleteSubjectList(id, idSubjects);
    }

}
