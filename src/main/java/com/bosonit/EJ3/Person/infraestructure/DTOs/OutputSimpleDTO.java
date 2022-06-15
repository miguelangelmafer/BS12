package com.bosonit.EJ3.Person.infraestructure.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class OutputSimpleDTO extends OutPersonaDTO{

    private Integer password;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
}
