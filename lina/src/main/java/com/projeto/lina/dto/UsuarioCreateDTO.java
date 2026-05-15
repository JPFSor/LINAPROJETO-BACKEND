package com.projeto.lina.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreateDTO {

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email obrigatório")
    private String email;

    @NotBlank(message = "Senha obrigatória")
    @Size(min = 6, message = "Senha deve ter ao menos 6 caracteres")
    private String senha;

    private List<String> restricoes;

    // Android envia como string única: "VEGANO", "CELIACO", etc.
    private String restricaoAlimentar;

    // Android envia o gênero selecionado no spinner
    private String genero;

    // Recebida como String "YYYY-MM-DD" do Android e convertida no Mapper
    private String dataNascimento;
}
