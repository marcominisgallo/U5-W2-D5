package it.epicode.U5_W2_D5.controller;

import it.epicode.U5_W2_D5.dto.ViaggioDto;
import it.epicode.U5_W2_D5.exception.NotFoundException;
import it.epicode.U5_W2_D5.model.StatoViaggio;
import it.epicode.U5_W2_D5.model.Viaggio;
import it.epicode.U5_W2_D5.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio saveViaggio(@RequestBody ViaggioDto viaggioDto) {
        return viaggioService.saveViaggio(viaggioDto);
    }

    @GetMapping("")
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    @GetMapping("/{id}")
    public Viaggio getViaggio(@PathVariable Long id) throws NotFoundException {
        return viaggioService.getViaggio(id);
    }

    @PutMapping("/{id}")
    public Viaggio updateViaggio(@PathVariable Long id, @RequestBody ViaggioDto viaggioDto) throws NotFoundException {
        return viaggioService.updateViaggio(id, viaggioDto);
    }

    @DeleteMapping("/{id}")
    public void deleteViaggio(@PathVariable Long id) throws NotFoundException {
        viaggioService.deleteViaggio(id);
    }

    @PatchMapping("/{id}/stato")
    public Viaggio aggiornaStatoViaggio(@PathVariable Long id, @RequestParam("stato") StatoViaggio stato) throws NotFoundException {
        return viaggioService.aggiornaStatoViaggio(id, stato);
    }
}