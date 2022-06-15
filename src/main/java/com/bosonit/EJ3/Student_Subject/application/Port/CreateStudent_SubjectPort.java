package com.bosonit.EJ3.Student_Subject.application.Port;

import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;

public interface CreateStudent_SubjectPort {
    public Student_SubjectEnt addSubject(Student_SubjectEnt student_subjectEnt);
}
