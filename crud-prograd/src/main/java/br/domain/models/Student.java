package br.ufal.lccv.java.springboot.crud.crudprograd.domain.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;
    private String cpf;
    private String nome;
    private String birthDate;
    private String rg;
    private String agency;
    private String UF;

    @ManyToOne
    private Course course;

    @ManyToMany
    private List<Discipline> disciplineList;

}
