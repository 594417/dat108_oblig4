package no.hvl.dat108.oblig4.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "oblig4")
public class Deltager {
    @Id
    public String mobil;
    public String hash;
    public String salt;
    public String fornavn;
    public String etternavn;
    public String kjonn;

    public Deltager (String mobil, String hash, String salt, String fornavn, String etternavn, String kjonn){
        this.mobil = mobil;
        this.hash = hash;
        this.salt = salt;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
    }

    public void setMobil(String mobil){
        this.mobil = mobil;
    }
    public void setHash(String hash){
        this.hash = hash;
    }
    public void setSalt(String salt){
        this.salt = salt;
    }
    public void setFornavn(String fornavn){
        this.fornavn = fornavn;
    }
    public void setEtternavn(String etternavn){
        this.etternavn = etternavn;
    }
    public void setKjonn(String kjonn){
        this.kjonn = kjonn;
    }
}