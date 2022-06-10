package com.accenuture.project.part2.Team1part2.modules;

import java.time.LocalDate;

public class Insured {

// XREIAZOMASTE OLI TIN PLIROFORIA???
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

    public Insured() { }

    public long getAfm() {
        return afm;
    }

    public void setAfm(long afm) {
        this.afm = afm;
    }

    public long getAmka() {
        return amka;
    }

    public void setAmka(long amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
