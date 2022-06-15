package com.bosonit.EJ3.Person.application.UseCase;


import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.application.Port.CreatePersonPort;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCase implements CreatePersonPort {

    @Autowired
    PersonaRepository personaRepository;

    public PersonaEnt addPersona(PersonaEnt personaEnt) throws Exception{
        if(personaEnt.getUsuario().length()>10){
            throw new Exception("El usuario no debe tener más de 10 caracteres");}

        if(personaEnt.getUsuario() == null || personaEnt.getPassword() == null || personaEnt.getName() == null ||
                personaEnt.getCompany_email() == null || personaEnt.getPersonal_email() == null || personaEnt.getCity() == null ||
                personaEnt.getActive() == null || personaEnt.getCreated_date() == null){
            throw new Exception("Alguno de los campos no puede ser nulo");}
        else{
            return personaRepository.save(personaEnt);}
    }
}
