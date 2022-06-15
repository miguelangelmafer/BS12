package com.bosonit.EJ3.Student_Subject.application.Port;

import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.InputStudent_SubjectDTO;

public interface UpdateStudent_SubjectPort {
    public Student_SubjectEnt updateSubject(Student_SubjectEnt subjectOld, InputStudent_SubjectDTO subjectNew);
}
