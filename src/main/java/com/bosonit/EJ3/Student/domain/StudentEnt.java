package com.bosonit.EJ3.Student.domain;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.StringPrefixedSequenceIdGenerator;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
@Table (name="Estudiantes")
public class StudentEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @GenericGenerator(

            name = "student_seq",

            strategy = "com.bosonit.EJ3.StringPrefixedSequenceIdGenerator",

            parameters = {

                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STD"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")

            })
    private String id_student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_persona")
    private PersonaEnt personaEnt;

    private Integer num_hours_week;

    private String comments;

    @NotNull
    private String branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_teacher")
    private TeacherEnt my_teacher;

    //relacion con asignaturas
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_subject",
            joinColumns = {@JoinColumn(name = "id_student")},
            inverseJoinColumns = {@JoinColumn(name = "id_subject")}
    )
    private List<Student_SubjectEnt> subjects = new ArrayList<>();
}
