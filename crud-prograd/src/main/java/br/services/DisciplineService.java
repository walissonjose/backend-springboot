package br.ufal.lccv.java.springboot.crud.crudprograd.services;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.DisciplineBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.DisciplineDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.DisciplineInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.ProfessorInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Discipline;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;
import br.ufal.lccv.java.springboot.crud.crudprograd.repositories.DisciplineRepository;
import br.ufal.lccv.java.springboot.crud.crudprograd.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplineService {
    private final DisciplineRepository repository;
    private final ProfessorRepository professorRepository;

    public Discipline create(DisciplineInput disciplineInput){
        Professor professor = professorRepository.getReferenceById(disciplineInput.getProfessorID());
        Discipline discipline = DisciplineBuilder.build((disciplineInput));
        discipline.setProfessor(professor);
        repository.save(discipline);

        return discipline;
    }

    public List<Discipline> findAll(){
        List<Discipline> disciplineList = repository.findAll();
        return disciplineList;
    }

    public Discipline findOne(UUID id){
        Discipline discipline= repository.getReferenceById(id);
        return discipline;
    }

    public Discipline updateProfessor(UUID professorID, UUID disciplineID){
        Professor professor = professorRepository.getReferenceById(professorID);
        Discipline discipline = repository.getReferenceById(disciplineID);
        discipline.setProfessor(professor);
        return discipline;
    }

}
