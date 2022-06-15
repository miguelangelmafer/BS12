package com.bosonit.EJ3.Person.application.UseCase;

import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.application.Port.GetPersonPort;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonUseCase implements GetPersonPort {

    @Autowired
    PersonaRepository personaRepository;

    public PersonaEnt getPersonaByID(Integer id) throws Exception
    {
        return personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));
    }

    //getnombre

    public List <PersonaEnt> getPersonByName(String name){
        List <PersonaEnt> listPersona = personaRepository.findByName(name);
        return listPersona;
    }
    //getall
    public List<PersonaEnt> getAllPerson() {
        List<PersonaEnt> personaList = personaRepository.findAll();
        return personaList;
    }

}
