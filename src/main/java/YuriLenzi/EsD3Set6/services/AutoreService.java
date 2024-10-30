package YuriLenzi.EsD3Set6.services;

import YuriLenzi.EsSet6D2.entities.Autore;
import YuriLenzi.EsSet6D2.payloads.NuovoAutorePayload;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutoreService {

    List<Autore> autoreList = new ArrayList<>();

    public Autore salvaAutore(NuovoAutorePayload nuovoAutorePayload) {
        Autore nuovoAutore = new Autore(
                nuovoAutorePayload.getNome(),
                nuovoAutorePayload.getCognome(),
                nuovoAutorePayload.getEmail(),
                LocalDate.parse(nuovoAutorePayload.getDataNascita()));
        autoreList.add(nuovoAutore);
        return nuovoAutore;
    }

    public List<Autore> vediAutori() {
        return autoreList;
    }
}
