package com.bosonit.EJ3.Teacher.infraestructure.DTOs;

import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class OutputFullTeacherDTO {
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
    private String id_teacher;
    private Integer num_hours_week;
    private String comments;
    private String branch;

    public OutputFullTeacherDTO(TeacherEnt teacher) {
        setId_teacher(teacher.getId_teacher());
        setComments(teacher.getComments());
        setId_persona(teacher.getPersonaEnt().getId_persona());
        setUsuario(teacher.getPersonaEnt().getUsuario());
        setPassword(teacher.getPersonaEnt().getPassword());
        setName(teacher.getPersonaEnt().getName());
        setSurname(teacher.getPersonaEnt().getSurname());
        setCompany_email(teacher.getPersonaEnt().getCompany_email());
        setPersona_email(teacher.getPersonaEnt().getPersonal_email());
        setCity(teacher.getPersonaEnt().getCity());
        setActive(teacher.getPersonaEnt().getActive());
        setCreated_date(teacher.getPersonaEnt().getCreated_date());
        setImagen_url(teacher.getPersonaEnt().getImagen_url());
        setTermination_date(teacher.getPersonaEnt().getTermination_date());
    }
}
