package br.ufal.lccv.java.springboot.crud.crudprograd.repositories;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}
