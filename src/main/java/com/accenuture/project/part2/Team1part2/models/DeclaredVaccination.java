package com.accenuture.project.part2.Team1part2.models;

import java.time.LocalDate;

public class DeclaredVaccination {

    private int timeslotCode;
    private long amka;
    private LocalDate expirationDate;

    //constructor for declarationOfVaccination() in DoctorService class
    public DeclaredVaccination(int timeslotCode, long amka, LocalDate expirationDate) {
        this.timeslotCode = timeslotCode;
        this.amka = amka;
        this.expirationDate = expirationDate;
    }

    //getters
    public int getTimeslotCode() {
        return timeslotCode;
    }

    public long getAmka() {
        return amka;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
