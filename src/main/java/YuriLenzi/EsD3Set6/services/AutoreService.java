package YuriLenzi.EsD3Set6.services;


import YuriLenzi.EsD3Set6.entities.Autore;
import YuriLenzi.EsD3Set6.exceptions.NotFoundException;
import YuriLenzi.EsD3Set6.exceptions.SameEmailException;
import YuriLenzi.EsD3Set6.payloads.NuovoAutorePayload;
import YuriLenzi.EsD3Set6.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public Autore salvaAutore(NuovoAutorePayload nuovoAutorePayload) {
        if (autoreRepository.existsByemail(nuovoAutorePayload.getEmail())) {
            throw new SameEmailException(nuovoAutorePayload.getEmail());
        } else {
            Autore nuovoAutore = new Autore(
                    nuovoAutorePayload.getNome(),
                    nuovoAutorePayload.getCognome(),
                    nuovoAutorePayload.getEmail(),
                    LocalDate.parse(nuovoAutorePayload.getDataNascita()));

            autoreRepository.save(nuovoAutore);
            return nuovoAutore;
        }
    }

    public List<Autore> vediAutori() {
        return autoreRepository.findAll();
    }

    public Autore findById(long idToFind) {
        Autore found = null;
        found = autoreRepository.findById(idToFind).orElseThrow(() -> new NotFoundException(idToFind));
        return found;
    }
}
