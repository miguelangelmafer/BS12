package com.bosonit.EJ3.Person.application.UseCase;

import com.bosonit.EJ3.Person.application.Port.DeletePersonPort;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase implements DeletePersonPort {

    @Autowired
    PersonaRepository personaRepository;

    public void deletePerson(PersonaEnt personaEnt){
        personaRepository.delete(personaEnt);
    }
}
