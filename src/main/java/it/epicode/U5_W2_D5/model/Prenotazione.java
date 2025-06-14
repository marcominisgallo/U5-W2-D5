package it.epicode.U5_W2_D5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Dipendente dipendente;

    @ManyToOne(optional = false)
    private Viaggio viaggio;

    @Column(nullable = false)
    private LocalDate dataRichiesta;

    private String note;
}