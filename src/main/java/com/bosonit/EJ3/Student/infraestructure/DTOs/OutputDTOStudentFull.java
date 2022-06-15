package com.bosonit.EJ3.Student.infraestructure.DTOs;


import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class OutputDTOStudentFull extends OutputStudentDTO {

    private Integer id_persona;
    private String usuario;
    private Integer password;
    private String name;
    private String surname;
    private String company_email;
    private String persona_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    private String id_student;
    private Integer num_hours_week;
    private String comments;
    //private String id_teacher;
    private String branch;

    public OutputDTOStudentFull(StudentEnt student) {
        super(student);
        setId_student(student.getId_student());
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setId_persona(student.getPersonaEnt().getId_persona());
        setUsuario(student.getPersonaEnt().getUsuario());
        setPassword(student.getPersonaEnt().getPassword());
        setName(student.getPersonaEnt().getName());
        setSurname(student.getPersonaEnt().getSurname());
        setCompany_email(student.getPersonaEnt().getCompany_email());
        setPersona_email(student.getPersonaEnt().getPersonal_email());
        setCity(student.getPersonaEnt().getCity());
        setActive(student.getPersonaEnt().getActive());
        setCreated_date(student.getPersonaEnt().getCreated_date());
        setImagen_url(student.getPersonaEnt().getImagen_url());
        setTermination_date(student.getPersonaEnt().getTermination_date());
    }
}