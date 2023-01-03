package br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Schema(description = "Representação de entrada de um novo professor.")
public class CourseInput {

    @Schema(description = "Nome do curso. Ex: Engenharia Quimica")
    @NotBlank(message = "The NAME cannot be EMPTY")
    private String name;

    @Schema(description = "Data na qual o curso foi criado")
    private String initialDate;

    @Schema(description = "Localizacao do curso dentro da UFAL")
    private String localization;

    @Schema(description = "UUID do professor responsavel pelo curso.")
    private UUID coordinatorID;
}
