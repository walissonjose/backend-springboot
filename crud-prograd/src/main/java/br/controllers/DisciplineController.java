package br.ufal.lccv.java.springboot.crud.crudprograd.controllers;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.DisciplineBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.DisciplineDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.DisciplineInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Discipline;
import br.ufal.lccv.java.springboot.crud.crudprograd.services.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/discipline")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplineController {

    private final DisciplineService service;
    @PostMapping("/")
    public DisciplineDTO create(@Valid @RequestBody DisciplineInput disciplineInput) {
        Discipline discipline = service.create(disciplineInput);
        return DisciplineBuilder.build(discipline);
    }

    @GetMapping("/findOne/{id}")
    public DisciplineDTO findOne(@PathVariable UUID id) {
        Discipline discipline = service.findOne(id);
        return DisciplineBuilder.build(discipline);
    }

    @GetMapping("/findAll")
    public List<DisciplineDTO> findAll() {
        List<Discipline> disciplineList = service.findAll();
        return DisciplineBuilder.build(disciplineList);
    }

    @PutMapping("/discipline/{disciplineID}/professor/{professorID}")
    @ResponseBody
    public DisciplineDTO updateProfessor(@PathVariable UUID disciplineID, @PathVariable UUID professorID) {
        Discipline discipline = service.updateProfessor(professorID, disciplineID);
        return DisciplineBuilder.build(discipline);
    }

}
