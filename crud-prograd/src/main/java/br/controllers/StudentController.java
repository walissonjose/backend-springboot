package br.ufal.lccv.java.springboot.crud.crudprograd.controllers;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.CourseBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.StudentBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.CourseDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.StudentDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.StudentInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Course;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Student;
import br.ufal.lccv.java.springboot.crud.crudprograd.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Students", description = "Endpoints de Estudantes")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private final StudentService service;
    @Operation(
            summary= "Criar um novo estudante",
            description = "Baseado na estrutura de requisição, adiciona um estudante no banco de dados!"
    )
    @PostMapping("/")
    public StudentDTO create(@Valid @RequestBody StudentInput studentInput){
        Student student = service.create(studentInput);
        return StudentBuilder.build(student);
    }

    @GetMapping("/findALl")
    public List<StudentDTO> findAll(){
        List<Student> allStudents = service.findAll();
        return StudentBuilder.build(allStudents);
    }

    @GetMapping("/findOne/{id}")
    public StudentDTO findOne(@PathVariable UUID id){
        Student student = service.findOne(id);
        return StudentBuilder.build(student);

    }

    @PutMapping("/student/{studentID}/course/{courseID}")
    @ResponseBody
    public StudentDTO updateCourse(@PathVariable UUID studentID, @PathVariable UUID courseID){
        Student student = service.updateCourse(studentID, courseID);
        return StudentBuilder.build(student);
    }

    @GetMapping("/getCourse/{id}")
    public CourseDTO getCourse(@PathVariable UUID id){
        Course course = service.getCourse(id);
        return CourseBuilder.build(course);
    }

    @PostMapping("/{studentID}/discipline/{disciplineID}")
    public StudentDTO matriculate(@PathVariable UUID studentID, @PathVariable UUID disciplineID){
        Student student = service.matriculate(studentID, disciplineID);
        return StudentBuilder.build(student);
    }

}
