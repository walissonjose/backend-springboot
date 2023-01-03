package br.ufal.lccv.java.springboot.crud.crudprograd.domain.builders;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.CourseDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos.DisciplineDTO;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs.CourseInput;
import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Course;

import java.util.LinkedList;
import java.util.List;

public class CourseBuilder {

    public static Course build(CourseInput courseInput){
        return Course.builder()
                .name(courseInput.getName())
                .initialDate(courseInput.getInitialDate())
                .localization(courseInput.getLocalization())
                .build();
    }

    public static CourseDTO build(Course course){
        return CourseDTO.builder()
                .courseId(course.getId())
                .initialDate(course.getInitialDate())
                .name(course.getName())
                .localization(course.getLocalization())
                .build();
    }

    public static List<CourseDTO> build(List<Course> courseList){
        List<CourseDTO> finalList = new LinkedList<>();
        for(Course course: courseList){
            CourseDTO courseDTO = build(course);
            finalList.add(courseDTO);
        }
        return finalList;
    }
}
