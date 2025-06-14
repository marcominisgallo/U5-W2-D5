package it.epicode.U5_W2_D5.controller;

import it.epicode.U5_W2_D5.dto.PrenotazioneDto;
import it.epicode.U5_W2_D5.exception.NotFoundException;
import it.epicode.U5_W2_D5.model.Prenotazione;
import it.epicode.U5_W2_D5.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione savePrenotazione(@RequestBody PrenotazioneDto prenotazioneDto) throws NotFoundException {
        return prenotazioneService.savePrenotazione(prenotazioneDto);
    }

    @GetMapping("")
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.getAllPrenotazioni();
    }

    @GetMapping("/{id}")
    public Prenotazione getPrenotazione(@PathVariable Long id) throws NotFoundException {
        return prenotazioneService.getPrenotazione(id);
    }

    @PutMapping("/{id}")
    public Prenotazione updatePrenotazione(@PathVariable Long id, @RequestBody PrenotazioneDto prenotazioneDto) throws NotFoundException {
        return prenotazioneService.updatePrenotazione(id, prenotazioneDto);
    }

    @DeleteMapping("/{id}")
    public void deletePrenotazione(@PathVariable Long id) throws NotFoundException {
        prenotazioneService.deletePrenotazione(id);
    }

    @PostMapping("/assegna")
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione assegnaDipendenteAViaggio(@RequestBody PrenotazioneDto prenotazioneDto) throws NotFoundException {
        return prenotazioneService.savePrenotazione(prenotazioneDto);
    }
}