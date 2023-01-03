package br.ufal.lccv.java.springboot.crud.crudprograd.services;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.ProfessorBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.ProfessorDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.ProfessorInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;
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
public class ProfessorService {

    private final ProfessorRepository repository;


    public Professor createProfessor(ProfessorInput professorInput){
        Professor professor = ProfessorBuilder.build(professorInput);
        repository.save(professor);

        return professor;
    }

    public List<Professor> findAll(){
        List<Professor> professorList = repository.findAll();
        return professorList;
    }

    public Professor findOne(UUID professorID){
        Professor professor = repository.getReferenceById(professorID);
        return professor;
    }
}
