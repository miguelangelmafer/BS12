package com.bosonit.EJ3.Teacher.infraestructure.Repository;

import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEnt,String> {
}
