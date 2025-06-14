package it.epicode.U5_W2_D5.service;

import it.epicode.U5_W2_D5.dto.ViaggioDto;
import it.epicode.U5_W2_D5.exception.NotFoundException;
import it.epicode.U5_W2_D5.model.StatoViaggio;
import it.epicode.U5_W2_D5.model.Viaggio;
import it.epicode.U5_W2_D5.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Viaggio saveViaggio(ViaggioDto dto) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(dto.getDestinazione());
        viaggio.setData(dto.getData());
        viaggio.setStato(dto.getStato());
        return viaggioRepository.save(viaggio);
    }

    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    public Viaggio getViaggio(Long id) throws NotFoundException {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Viaggio con id " + id + " non trovato"));
    }

    public Viaggio updateViaggio(Long id, ViaggioDto dto) throws NotFoundException {
        Viaggio viaggio = getViaggio(id);
        viaggio.setDestinazione(dto.getDestinazione());
        viaggio.setData(dto.getData());
        viaggio.setStato(dto.getStato());
        return viaggioRepository.save(viaggio);
    }

    public void deleteViaggio(Long id) throws NotFoundException {
        Viaggio viaggio = getViaggio(id);
        viaggioRepository.delete(viaggio);
    }

    public Viaggio aggiornaStatoViaggio(Long id, StatoViaggio stato) throws NotFoundException {
        Viaggio viaggio = getViaggio(id);
        viaggio.setStato(stato);
        return viaggioRepository.save(viaggio);
    }
}