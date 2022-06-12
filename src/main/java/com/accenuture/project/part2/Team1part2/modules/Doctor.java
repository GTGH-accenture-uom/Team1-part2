package com.accenuture.project.part2.Team1part2.modules;

public class Doctor {

    private long amka;
    private String name;
    private String surname;

    public Doctor(long amka, String doctor_name, String doctor_surname) {
        this.amka = amka;
        this.name = doctor_name;
        this.surname = doctor_surname;
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




}
