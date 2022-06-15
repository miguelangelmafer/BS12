package com.bosonit.EJ3.Person.infraestructure.Controller;


import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.application.Port.DeletePersonPort;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.application.UseCase.GetPersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class DeletePerson {

    @Autowired
    GetPersonUseCase getPersonUseCase;

    @Autowired
    DeletePersonPort deletePersonPort;

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) throws Exception {
        try {
            PersonaEnt personaEnt = getPersonUseCase.getPersonaByID(id);
            deletePersonPort.deletePerson(personaEnt);
            return "Persona eliminada";
        } catch (Exception e) {
            throw new NotFoundException("El ususario: " + id + " no existe y no se puede eliminar");
        }
    }
}