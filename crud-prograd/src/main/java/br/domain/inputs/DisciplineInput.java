package br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs;

import br.ufal.lccv.java.springboot.crud.crudprograd.domain.models.Professor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Schema(description = "Representação de entrada de um novo professor.")
public class DisciplineInput {

    @Schema(description = "Nome da disciplina Ex: Tecnologia dos materiais")
    @NotBlank(message = "The NAME cannot be EMPTY")
    private String name;

    @Schema(description = "Descricao da disciplina.")
    private String description;

    @Schema(description = "Codigo da disciplina. Ex: EQUI001")
    private String code;

    @Schema(description = "Codigo do professor que leciona esta disciplina.")
    private UUID professorID;

}
