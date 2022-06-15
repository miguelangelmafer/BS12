package com.bosonit.EJ3.Person.application.Port;


import com.bosonit.EJ3.Person.domain.PersonaEnt;

public interface CreatePersonPort {
    public PersonaEnt addPersona(PersonaEnt personaEnt) throws Exception;
}
