package com.bosonit.EJ3.Student_Subject.application.UseCase;

import com.bosonit.EJ3.Student_Subject.application.Port.DeleteStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.Repository.Student_SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudent_SubjectUseCase implements DeleteStudent_SubjectPort {
    @Autowired
    Student_SubjectRepository student_subjectRepository;

    public void deleteSubject(Student_SubjectEnt student_subjectEnt){
        student_subjectRepository.delete(student_subjectEnt);
    }
}
