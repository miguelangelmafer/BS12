package com.bosonit.EJ3.Student_Subject.infraestructure.DTOs;

import lombok.Data;

import java.util.Date;
@Data
public class InputStudent_SubjectDTO{
        private String id_subject;
        private String subject;
        private String comments;
        private Date initial_date;
        private Date finish_date;
        private String id_student;
}
