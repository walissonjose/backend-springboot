package br.ufal.lccv.java.springboot.crud.crudprograd.domain.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@Schema(description = "Representação de entrada de um novo estudante.")
public class StudentInput {

    @Schema(description = "CPF do estudante")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
    @NotBlank(message = "The CPF cannot be EMPTY")
    private String cpf;

    @Schema(description = "Nome do estudante!")
    @NotBlank(message = "The NAME cannot be EMPTY")
    private String nome;

    @Schema(description = "Data de nascimento do usuário")
    private String birthDate;

    @Schema(description = "RG do estudante")
    private String rg;

    @Schema(description = "Agencia que emitiu o RG")
    private String agency;

    @Schema(description = "Estado onde o RG foi emitido")
    private String UF;

    @Schema(description = "ID do curso que o estudante cursa")
    private UUID courseID;
}
