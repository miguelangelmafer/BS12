package com.bosonit.EJ3.Person.application.UseCase;

import com.bosonit.EJ3.Person.application.Port.UpdatePersonaPort;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCase implements UpdatePersonaPort {

    @Autowired
    PersonaRepository personaRepository;
    public PersonaEnt updatePerson(PersonaEnt personaOld, InputPersonaDTO personaNew) {

        personaOld.setPassword(personaNew.getPassword());
        personaOld.setName(personaNew.getName());
        personaOld.setSurname(personaNew.getSurname());
        personaOld.setCompany_email(personaNew.getCompany_email());
        personaOld.setPersonal_email(personaNew.getPersonal_email());
        personaOld.setCity(personaNew.getCity());
        personaOld.setActive(personaNew.getActive());
        personaOld.setCreated_date(personaNew.getCreated_date());
        personaOld.setImagen_url(personaNew.getImagen_url());
        personaOld.setTermination_date(personaNew.getTermination_date());
        personaOld.setUsuario(personaNew.getUsuario());
        personaOld.setId_persona(personaOld.getId_persona());

        return personaRepository.save(personaOld);
    }
}
