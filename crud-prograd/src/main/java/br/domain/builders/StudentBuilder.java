package br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.StudentDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.StudentInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentBuilder {

    public static Student build(StudentInput input){
        return Student.builder()
                .cpf(input.getCpf())
                .nome(input.getNome())
                .birthDate(input.getBirthDate())
                .rg(input.getRg())
                .agency(input.getAgency())
                .UF(input.getUF())
                .build();
    }

    public static StudentDTO build(Student student){
        return StudentDTO.builder()
                .studentId(student.getId())
                .rg(student.getRg())
                .agency(student.getAgency())
                .UF(student.getUF())
                .cpf(student.getCpf())
                .birthDate(student.getBirthDate())
                .nome(student.getNome())
                .build();
    }

    public static List<StudentDTO> build(List<Student> students){
        List<StudentDTO> finalList = new LinkedList<>();
        for (Student student : students){
            StudentDTO studentDTO = build(student);
            finalList.add(studentDTO);
        }
        return finalList;
    }
}
