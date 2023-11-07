package no.hvl.dat108.oblig4.models;

import java.lang.annotation.Repeatable;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(schema = "oblig4")
public class Deltager {
    @Id
    private String mobil;
    private String hash;
    private String salt;
    private String fornavn;
    private String etternavn;
    private String kjonn;
}