package br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Schema(description = "Representação de entrada de um novo professor.")
public class ProfessorInput {

    @Schema(description = "Nome do professor")
    @NotBlank(message = "The NAME cannot be EMPTY")
    private String name;

    @Schema(description = "CPF do professor")
    @NotBlank(message = "The CPF cannot be EMPTY")
    private String cpf;

    @Schema(description = "titulacao do professor.")
    private String title;
}
