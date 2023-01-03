package br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.DisciplineDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.DisciplineInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Discipline;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;

import java.util.LinkedList;
import java.util.List;

public class DisciplineBuilder {

    public static Discipline build(DisciplineInput disciplineInput){
        return Discipline.builder()
                .code(disciplineInput.getCode())
                .name(disciplineInput.getName())
                .description(disciplineInput.getDescription())
                .build();
    }

    public static DisciplineDTO build(Discipline discipline){
        return DisciplineDTO.builder()
                .disciplineId(discipline.getId())
                .code(discipline.getCode())
                .name(discipline.getName())
                .description(discipline.getDescription())
                .build();
    }

    public static List<DisciplineDTO> build(List<Discipline> disciplineList){
        List<DisciplineDTO> finalList = new LinkedList<>();
        for (Discipline discipline : disciplineList){
            DisciplineDTO disciplineDTO = build(discipline);
            finalList.add(disciplineDTO);
        }
        return finalList;
    }
}
