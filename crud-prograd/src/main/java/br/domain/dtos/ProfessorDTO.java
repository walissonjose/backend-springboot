package br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProfessorDTO {

    @Schema(description = "ID do professor")
    private UUID professorId;
    @Schema(description = "Nome do professor")
    private String name;
    @Schema(description = "CPF do professor")
    private String cpf;
    @Schema(description = "Titulo do professor")
    private String title;



}
