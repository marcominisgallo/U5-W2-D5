package it.epicode.U5_W2_D5.dto;

import it.epicode.U5_W2_D5.model.StatoViaggio;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioDto {
    @NotBlank
    private String destinazione;

    @NotNull
    @FutureOrPresent
    private LocalDate data;

    @NotNull
    private StatoViaggio stato;
}