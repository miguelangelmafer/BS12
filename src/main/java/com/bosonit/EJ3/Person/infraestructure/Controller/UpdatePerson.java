package com.bosonit.EJ3.Person.infraestructure.Controller;

import com.bosonit.EJ3.Person.Exceptions.UnprocesableException;
import com.bosonit.EJ3.Person.application.Port.UpdatePersonaPort;
import com.bosonit.EJ3.Person.application.UseCase.GetPersonUseCase;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")

public class UpdatePerson {

    @Autowired
    GetPersonUseCase getPersonUseCase;
    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("/update/{id}")
    public PersonaEnt updatePersona(@PathVariable Integer id, @RequestBody InputPersonaDTO inputPersonaDTO) throws Exception{
            PersonaEnt personaEnt = getPersonUseCase.getPersonaByID(id);
            if(inputPersonaDTO.getUsuario().length()>10){
                throw new UnprocesableException("Usuario debe tener menos de 10 caracteres");
            }
        if(inputPersonaDTO.getUsuario() == null || inputPersonaDTO.getPassword() == null || inputPersonaDTO.getName() == null ||
                inputPersonaDTO.getCompany_email() == null || inputPersonaDTO.getPersonal_email() == null || inputPersonaDTO.getCity() == null ||
                inputPersonaDTO.getActive() == null || inputPersonaDTO.getCreated_date() == null){
            throw new UnprocesableException("Alguno de los campos no puede ser nulo");
        }
        else
            updatePersonaPort.updatePerson(personaEnt,inputPersonaDTO);
            return personaEnt;
        }

    }

