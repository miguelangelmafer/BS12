package com.bosonit.EJ3.Student.application.Port;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;

import java.util.List;

public interface UpdateStudentPort {
    public StudentEnt updateStudent(StudentEnt studentOld, InputStudentDTO studentNew);

    public List<OutputStudent_SubjectDTO> addSubjectList (String id, List<String> idSubjects) throws Exception;

    public List<OutputStudent_SubjectDTO> deleteSubjectList (String id, List<String> idSubjects) throws Exception;
}
