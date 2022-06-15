package com.bosonit.EJ3.Student.infraestructure.Repository;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEnt,String> {
}
