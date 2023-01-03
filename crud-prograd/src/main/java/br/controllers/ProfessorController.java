package br.ufal.lccv.java.springboot.crud.crudprograd.controllers;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.ProfessorBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.ProfessorDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.ProfessorInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;
import br.ufal.lccv.java.springboot.crud.crudprograd.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping("/")
    public ProfessorDTO createProfessor(@RequestBody ProfessorInput professorInput){
        Professor professor = service.createProfessor(professorInput);
        return ProfessorBuilder.build(professor);
    }

    @GetMapping("/findOne/{id}")
    public ProfessorDTO findOne(@PathVariable UUID id){
        return ProfessorBuilder.build(service.findOne(id));
    }

    @GetMapping("/findAll")
    public List<ProfessorDTO> findAll(){
        return ProfessorBuilder.build(service.findAll());
    }


}
