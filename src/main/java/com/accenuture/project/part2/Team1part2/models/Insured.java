package com.accenuture.project.part2.Team1part2.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Insured implements Serializable {

    private long afm;
    private long amka;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String email;

    //constructors
    public Insured(long afm, long amka, String name, String surname, LocalDate birthdate, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.surname= surname;
        this.birthdate = birthdate;
        this.email = email;
    }

    //getters
    public long getAfm() {return afm;}

    public long getAmka() {return amka;}

    public String getName() {return name;}

    public String getSurname() {return surname;}

    public LocalDate getBirthdate() {return birthdate;}

    public String getEmail() {return email;}

    public void setAfm(long afm) {
        this.afm = afm;
    }

    public void setAmka(long amka) {
        this.amka = amka;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
