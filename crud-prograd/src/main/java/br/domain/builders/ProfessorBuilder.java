package br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.ProfessorDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.StudentDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.ProfessorInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Student;

import java.util.LinkedList;
import java.util.List;

public class ProfessorBuilder {

    public static Professor build(ProfessorInput professorInput){
        return Professor.builder()
                .cpf(professorInput.getCpf())
                .name(professorInput.getName())
                .title(professorInput.getTitle())
                .build();
    }

    public static ProfessorDTO build(Professor professor){
        return ProfessorDTO.builder()
                .professorId(professor.getId())
                .cpf(professor.getCpf())
                .name(professor.getName())
                .title(professor.getTitle())
                .build();
    }

    public static List<ProfessorDTO> build(List<Professor> professorList){
        List<ProfessorDTO> finalList = new LinkedList<>();
        for (Professor professor : professorList){
            ProfessorDTO professorDTO = build(professor);
            finalList.add(professorDTO);
        }
        return finalList;
    }
}
