package it.epicode.U5_W2_D5.service;

import it.epicode.U5_W2_D5.dto.DipendenteDto;
import it.epicode.U5_W2_D5.exception.NotFoundException;
import it.epicode.U5_W2_D5.model.Dipendente;
import it.epicode.U5_W2_D5.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Dipendente saveDipendente(DipendenteDto dto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(dto.getUsername());
        dipendente.setNome(dto.getNome());
        dipendente.setCognome(dto.getCognome());
        dipendente.setEmail(dto.getEmail());
        return dipendenteRepository.save(dipendente);
    }

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendente(Long id) throws NotFoundException {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dipendente con id " + id + " non trovato"));
    }

    public Dipendente updateDipendente(Long id, DipendenteDto dto) throws NotFoundException {
        Dipendente dipendente = getDipendente(id);
        dipendente.setUsername(dto.getUsername());
        dipendente.setNome(dto.getNome());
        dipendente.setCognome(dto.getCognome());
        dipendente.setEmail(dto.getEmail());
        return dipendenteRepository.save(dipendente);
    }

    public void deleteDipendente(Long id) throws NotFoundException {
        Dipendente dipendente = getDipendente(id);
        dipendenteRepository.delete(dipendente);
    }

    public Dipendente uploadImmagineProfilo(Long id, MultipartFile file) throws NotFoundException, IOException {
        Dipendente dipendente = getDipendente(id);
        String uploadDir = "uploads/profili/";
        new File(uploadDir).mkdirs();
        String filePath = uploadDir + "dipendente_" + id + "_" + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        dipendente.setImmagineProfilo(filePath);
        return dipendenteRepository.save(dipendente);
    }
}