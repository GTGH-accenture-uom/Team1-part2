package com.accenuture.project.part2.Team1part2.models;

import java.time.LocalDate;


public class DeclaredVaccination {

    private int timeslotCode1;
    private long amka;
    private LocalDate expirationDate;

    //constructor for declarationOfVaccination() in DoctorService class
    public DeclaredVaccination(int timeslotCode1, long amka, LocalDate expirationDate) {
        this.timeslotCode1 = timeslotCode1;
        this.amka = amka;
        this.expirationDate = expirationDate;
    }

    //getters
    public int getTimeslotCode1() {
        return timeslotCode1;
    }

    public long getAmka() {
        return amka;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
