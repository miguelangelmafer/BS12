package com.bosonit.EJ3.Student_Subject.application.Port;

import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;

import java.util.List;

public interface GetStudent_SubjectPort {
    public Student_SubjectEnt getSubjectByID(String id) throws Exception;
    public List<Student_SubjectEnt> getAllSubject();
    public List <Student_SubjectEnt> getSubjectByName(String subject);
    public List<OutputStudent_SubjectDTO> getSubjectStudent(String id);

}
