package br.ufal.lccv.java.springboot.crud.crudprograd.controllers;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.CourseBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.StudentBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.CourseDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.StudentDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.CourseInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Course;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Student;
import br.ufal.lccv.java.springboot.crud.crudprograd.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {

    private final CourseService service;

    @PostMapping("/")
    public CourseDTO create(@Valid @RequestBody CourseInput courseInput){
        Course course = service.create(courseInput);
        return CourseBuilder.build(course);
    }

    @GetMapping("/{id}/students")
    public List<StudentDTO> findAllStudents(@PathVariable UUID id){
        List<Student> studentList = service.findAllStudent(id);
        return StudentBuilder.build(studentList);
    }

}
