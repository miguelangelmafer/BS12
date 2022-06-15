package com.bosonit.EJ3.Student_Subject.infraestructure.Repository;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Student_SubjectRepository extends JpaRepository<Student_SubjectEnt,String> {
    List<Student_SubjectEnt> findBySubject(String subject);
}
