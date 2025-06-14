package it.epicode.U5_W2_D5.repository;

import it.epicode.U5_W2_D5.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
}