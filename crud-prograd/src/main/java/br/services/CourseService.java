package br.ufal.lccv.java.springboot.crud.crudprograd.services;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.CourseBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.StudentBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.CourseInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.StudentInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Course;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Student;
import br.ufal.lccv.java.springboot.crud.crudprograd.repositories.CourseRepository;
import br.ufal.lccv.java.springboot.crud.crudprograd.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService {

    public final CourseRepository repository;
    public final ProfessorRepository professorRepository;
    public Course create(CourseInput courseInput) {
        Professor professor = professorRepository.getReferenceById(courseInput.getCoordinatorID());
        Course course = CourseBuilder.build(courseInput);
        course.setCoordinator(professor);
        repository.save(course);
        return course;
    }

    public List<Student> findAllStudent(UUID id){
        Course course = repository.getReferenceById(id);
        return course.getStudents();
    }
}
