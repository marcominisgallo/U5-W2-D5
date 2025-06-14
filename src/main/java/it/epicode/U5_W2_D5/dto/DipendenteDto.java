package it.epicode.U5_W2_D5.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteDto {
    @NotBlank
    private String username;
    @NotBlank
    private String nome;
    @NotBlank
    private String cognome;
    @NotBlank
    @Email
    private String email;
}