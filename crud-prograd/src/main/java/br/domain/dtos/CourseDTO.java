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
public class CourseDTO {

    @Schema(description = "ID do curso")
    private UUID courseId;

    @Schema(description = "Nome do curso")
    private String name;

    @Schema(description = "Data na qual o curso foi criado")
    private String initialDate;

    @Schema(description = "Localizacao do curso dentro da UFAL")
    private String localization;

    @Schema(description = "Coordenador do curso")
    private ProfessorDTO coordinator;
}
