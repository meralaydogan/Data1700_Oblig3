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
        String sql="delete from Bilets";
        db.update(sql);
    }
    public Kunde hent(int id) {
        String sql="select * from Kunde where id=?";
        List<Kunde> etKunde=db.query(sql, new BeanPropertyRowMapper<>(Kunde.class),id );
        return etKunde.get(id-1);

    }
    public void endreKunde(Kunde kunde) {
        String sql="Update Kunde set film=?, antall=?, fornavn=?, etternavn=?," +
                "telefonnr=?, epost=? where id=?";
        db.update(sql,kunde.getFilm(),kunde.getAntall(),kunde.getFornavn(),kunde.getEtternavn(),
                kunde.getTelefonnr(), kunde.getEpost(),kunde.getId());



    }

    public void slettEtKunde(int id) {
        String sql = "DELETE FROM Kunde WHERE id=?";
        db.update(sql,id);
    }
}
