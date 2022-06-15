package com.accenuture.project.part2.Team1part2.models;

import java.io.Serializable;

public class Doctor implements Serializable {

    private long amka;
    private String name;
    private String surname;

    public Doctor(long amka, String doctor_name, String doctor_surname) {
        this.amka = amka;
        this.name = doctor_name;
        this.surname = doctor_surname;
    }

    //getters
    public long getAmka() {
        return amka;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
