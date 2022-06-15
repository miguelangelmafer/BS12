package com.bosonit.EJ3.Teacher.domain;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.StringPrefixedSequenceIdGenerator;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Profesores")
public class TeacherEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @GenericGenerator(

            name = "teacher_seq",

            strategy = "com.bosonit.EJ3.StringPrefixedSequenceIdGenerator",

            parameters = {

                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TCH"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")

            })
    private String id_teacher;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_persona")
    private PersonaEnt personaEnt;

    private String comments;

    @NotNull
    private String branch;

    @OneToMany(mappedBy = "my_teacher",cascade = CascadeType.ALL)
    private List<StudentEnt> students = new ArrayList<>();
}
