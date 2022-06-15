package com.bosonit.EJ3.Student_Subject.infraestructure.DTOs;

import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class OutputStudent_SubjectDTO {

    private String id_subject;
    private String subject;
    private String comments;
    private Date initial_date;
    private Date finish_date;

        public OutputStudent_SubjectDTO(Student_SubjectEnt subject) {
            setId_subject(subject.getId_subject());
            setSubject(subject.getSubject());
            setComments(subject.getComments());
            setInitial_date(subject.getInitial_date());
            setFinish_date(subject.getFinish_date());
        }
}
