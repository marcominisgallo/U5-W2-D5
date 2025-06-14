package it.epicode.U5_W2_D5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneDto {
    @NotNull
    private Long dipendenteId;
    @NotNull
    private Long viaggioId;
    @NotNull
    private LocalDate dataRichiesta;
    private String note;
}