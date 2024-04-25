package com.example.data1700_oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KundeRepository {
    @Autowired
    private JdbcTemplate db;
    public void lagre(Kunde kunde) {
        String sql="insert into Kunde(film,antall,fornavn, etternavn, telefonnr, epost) " +
                "values(?,?,?,?,?,?)";
        db.update(sql,kunde.getFilm(),kunde.getAntall(),kunde.getFornavn(),
                kunde.getEtternavn(),kunde.getTelefonnr(),kunde.getEpost());
    }
    public List<Kunde> hentAlleKunde() {
        String sql="select * from Kunde Order by fornavn ";
        List<Kunde> allekunder= db.query(sql, new BeanPropertyRowMapper<Kunde>(Kunde.class));
        return allekunder;
    }
    public void slett(){
        String sql="delete from Kunde";
        db.update(sql);
    }
    public void sletkunden(Long id) {
        String ticketSQL = "DELETE from Kunde WHERE id = " + id;
        db.update(ticketSQL);
    }
    public void updateKunden(Kunde kunde) {
        String ticketSQL = "INSERT INTO Kunde (film,antall,fornavn,etternavn,telefonnr,epost) VALUES(?,?,?,?,?,?) where id=?";
        db.update(ticketSQL, kunde.getFilm(), kunde.getAntall(), kunde.getFornavn(), kunde.getEtternavn(), kunde.getTelefonnr(), kunde.getEpost(),kunde.getId() );
    }
    public Kunde hentKunden(int id){
        String sql="select * from Bilets where id=?";
        List<Kunde> kunden=db.query(sql, new BeanPropertyRowMapper<>(Kunde.class),id );
        return kunden.get(id-1);
    }


}
