package br.ufal.lccv.java.springboot.crud.crudprograd.services;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.DisciplineBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders.StudentBuilder;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.StudentInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Course;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Discipline;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Student;
import br.ufal.lccv.java.springboot.crud.crudprograd.repositories.CourseRepository;
import br.ufal.lccv.java.springboot.crud.crudprograd.repositories.DisciplineRepository;
import br.ufal.lccv.java.springboot.crud.crudprograd.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final DisciplineRepository disciplineRepository;

    public Student create(StudentInput studentInput) {

        Course course = courseRepository.getReferenceById(studentInput.getCourseID());

        Student student = StudentBuilder.build(studentInput);
        student.setCourse(course);
        studentRepository.save(student);

        return student;
    }

    public List<Student> findAll(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }

    public Student findOne(UUID id){
        Student student = studentRepository.getReferenceById(id);
        return student;
    }

    public Student updateCourse(UUID studentID, UUID courseID){
        Student student = studentRepository.getReferenceById(studentID);
        Course course = courseRepository.getReferenceById(courseID);
        student.setCourse(course);
        return student;
    }

    public Course getCourse(UUID id){
        Student student = studentRepository.getReferenceById(id);
        Course course = student.getCourse();
        return course;
    }

    public Student matriculate(UUID studentID, UUID disciplineID){
        Student student = studentRepository.getReferenceById(studentID);
        Discipline discipline = disciplineRepository.getReferenceById(disciplineID);
        List<Discipline> disciplineList = student.getDisciplineList();
        List<Student> studentList = discipline.getStudentList();

        studentList.add(student);
        disciplineList.add(discipline);
        student.setDisciplineList(disciplineList);
        discipline.setStudentList(studentList);

        studentRepository.save(student);
        disciplineRepository.save(discipline);

        return student;


    }
}
