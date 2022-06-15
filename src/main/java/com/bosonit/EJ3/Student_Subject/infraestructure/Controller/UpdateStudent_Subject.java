package com.bosonit.EJ3.Student_Subject.infraestructure.Controller;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ3.Student_Subject.application.Port.GetStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.application.Port.UpdateStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.InputStudent_SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class UpdateStudent_Subject {
    @Autowired
    GetStudent_SubjectPort getStudent_subjectPort;
    @Autowired
    UpdateStudent_SubjectPort updateStudent_subjectPort;

    @PutMapping("/update/{id}")
    public Student_SubjectEnt updateSubject(@PathVariable String id, @RequestBody InputStudent_SubjectDTO inputStudent_subjectDTO) throws Exception {
        Student_SubjectEnt student_subjectEnt = getStudent_subjectPort.getSubjectByID(id);
        updateStudent_subjectPort.updateSubject(student_subjectEnt, inputStudent_subjectDTO);
        return student_subjectEnt;
    }
}
