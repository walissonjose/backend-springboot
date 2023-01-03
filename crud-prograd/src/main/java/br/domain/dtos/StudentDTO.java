package br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Schema(description = "Entidade estudante")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {

    @Schema(description = "Id do estudante")
    private UUID studentId;

    @Schema(description = "CPF do estudante")
    private String cpf;

    @Schema(description = "Nome do estudante!")
    private String nome;

    @Schema(description = "Data de nascimento do usuário")
    private String birthDate;

    @Schema(description = "RG do estudante")
    private String rg;

    @Schema(description = "Agencia que emitiu o RG")
    private String agency;

    @Schema(description = "Estado onde o RG foi emitido")
    private String UF;

    @Schema(description = "Curso do estudante")
    private CourseDTO course;

    @Schema(description = "Curso do estudante")
    private List<DisciplineDTO> disciplineDTOList;

}
