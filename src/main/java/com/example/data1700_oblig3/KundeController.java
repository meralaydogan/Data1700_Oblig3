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
    @GetMapping("/hentetKunde")
    public Kunde hentetKunde(int id)  {return rep.hent(id);}
    @PostMapping("/endreEtKunde")
    public void endreEtKunde(Kunde kunde){rep.endreKunde(kunde);}
    @GetMapping("/slettEtKunde")
    public void slettEtKunde(int id) {rep.slettEtKunde(id);}
}
