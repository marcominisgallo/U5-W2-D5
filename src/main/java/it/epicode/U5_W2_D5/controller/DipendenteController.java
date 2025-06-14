package it.epicode.U5_W2_D5.controller;

import it.epicode.U5_W2_D5.dto.DipendenteDto;
import it.epicode.U5_W2_D5.exception.NotFoundException;
import it.epicode.U5_W2_D5.model.Dipendente;
import it.epicode.U5_W2_D5.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente saveDipendente(@RequestBody DipendenteDto dipendenteDto) {
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @GetMapping("")
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public Dipendente getDipendente(@PathVariable Long id) throws NotFoundException {
        return dipendenteService.getDipendente(id);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable Long id, @RequestBody DipendenteDto dipendenteDto) throws NotFoundException {
        return dipendenteService.updateDipendente(id, dipendenteDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDipendente(@PathVariable Long id) throws NotFoundException {
        dipendenteService.deleteDipendente(id);
    }
}