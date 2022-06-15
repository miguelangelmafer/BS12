package com.bosonit.EJ3.Student.infraestructure.Controller;

import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.application.Port.DeletePersonPort;
import com.bosonit.EJ3.Person.application.UseCase.GetPersonUseCase;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student.application.Port.DeleteStudentPort;
import com.bosonit.EJ3.Student.application.Port.GetStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class DeleteStudent {
    @Autowired
    GetStudentPort getStudentPort;

    @Autowired
    DeleteStudentPort deleteStudentPort;

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) throws Exception {

            StudentEnt studentEnt = getStudentPort.getStudentByID(id);
            deleteStudentPort.deleteStudent(studentEnt);
            return "Persona eliminada";

    }
}
