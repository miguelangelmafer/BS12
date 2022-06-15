package com.bosonit.EJ3.Person.application.Port;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;

public interface UpdatePersonaPort {

    public PersonaEnt updatePerson(PersonaEnt personaOld, InputPersonaDTO personaNew);
}
