package it.epicode.U5_W2_D5.service;

import it.epicode.U5_W2_D5.dto.PrenotazioneDto;
import it.epicode.U5_W2_D5.exception.NotFoundException;
import it.epicode.U5_W2_D5.model.Dipendente;
import it.epicode.U5_W2_D5.model.Prenotazione;
import it.epicode.U5_W2_D5.model.Viaggio;
import it.epicode.U5_W2_D5.repository.DipendenteRepository;
import it.epicode.U5_W2_D5.repository.PrenotazioneRepository;
import it.epicode.U5_W2_D5.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Prenotazione savePrenotazione(PrenotazioneDto dto) throws NotFoundException {
        Dipendente dipendente = dipendenteRepository.findById(dto.getDipendenteId())
                .orElseThrow(() -> new NotFoundException("Dipendente con id " + dto.getDipendenteId() + " non trovato"));
        Viaggio viaggio = viaggioRepository.findById(dto.getViaggioId())
                .orElseThrow(() -> new NotFoundException("Viaggio con id " + dto.getViaggioId() + " non trovato"));

        // Controllo sovrapposizione
        boolean esiste = prenotazioneRepository.existsByDipendenteIdAndDataRichiesta(dto.getDipendenteId(), dto.getDataRichiesta());
        if (esiste) {
            throw new IllegalArgumentException("Dipendente già impegnato in un viaggio in questa data");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(dto.getDataRichiesta());
        prenotazione.setNote(dto.getNote());
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazione(Long id) throws NotFoundException {
        return prenotazioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prenotazione con id " + id + " non trovata"));
    }

    public Prenotazione updatePrenotazione(Long id, PrenotazioneDto dto) throws NotFoundException {
        Prenotazione prenotazione = getPrenotazione(id);
        Dipendente dipendente = dipendenteRepository.findById(dto.getDipendenteId())
                .orElseThrow(() -> new NotFoundException("Dipendente con id " + dto.getDipendenteId() + " non trovato"));
        Viaggio viaggio = viaggioRepository.findById(dto.getViaggioId())
                .orElseThrow(() -> new NotFoundException("Viaggio con id " + dto.getViaggioId() + " non trovato"));

        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(dto.getDataRichiesta());
        prenotazione.setNote(dto.getNote());
        return prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(Long id) throws NotFoundException {
        Prenotazione prenotazione = getPrenotazione(id);
        prenotazioneRepository.delete(prenotazione);
    }
}