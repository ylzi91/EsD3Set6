package YuriLenzi.EsD3Set6.controllers;

import YuriLenzi.EsSet6D2.entities.Autore;
import YuriLenzi.EsSet6D2.payloads.NuovoAutorePayload;
import YuriLenzi.EsSet6D2.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AutoreController {
    @Autowired
    AutoreService autoreService;

    @GetMapping("/autori")
    public List<Autore> trovaTuttiAutori() {
        return autoreService.vediAutori();
    }

    @PostMapping("/autori")
    public Autore aggiungiAutore(@RequestBody NuovoAutorePayload body) {
        return autoreService.salvaAutore(body);
    }
}
