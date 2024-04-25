package com.example.data1700_oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KundeController {
    @Autowired
    private KundeRepository rep;
    @PostMapping("/lagreKunde")
    public void lagreKunde(Kunde kunde){rep.lagre(kunde);}
    @GetMapping("/hentKunder")
    public List<Kunde> hentBiletter(){return rep.hentAlleKunde();}
    @GetMapping("/sletAlleKunder")
    public void sletAlleKunder(){ rep.slett();}
    @GetMapping("/sletkunden")
    public void slettKunden(long id) {rep.sletkunden(id);}
    @GetMapping("/hentKunden")
    public Kunde hentKunden(int id){return rep.hentKunden(id);}
    @GetMapping("/updateKunden")
    public void updateKunden(Kunde kunde){rep.updateKunden(kunde);}
}
