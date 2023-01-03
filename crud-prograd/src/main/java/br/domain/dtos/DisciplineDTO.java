package br.ufal.lccv.java.springboot.crud.crudprograd.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {

    @Schema(description = "ID da Disciplina!")
    private UUID disciplineId;
    @Schema(description = "Nome da Disciplina")
    private String name;
    @Schema(description = "Descricao do conteudo abordado na disciplina")
    private String description;
    @Schema(description = "Codigo de identificacao da disciplina")
    private String code;

    @Schema(description = "Professor que leciona esta disciplina.")
    private ProfessorDTO professorDTO;
}
