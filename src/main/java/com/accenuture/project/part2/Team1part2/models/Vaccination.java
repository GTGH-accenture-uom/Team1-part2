package com.accenuture.project.part2.Team1part2.models;

import java.time.LocalDate;

public class Vaccination {

    private Insured insured;
   // private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;


    // constructor called in vaccination service- declaration of vaccination from doctor
    public Vaccination(Insured insured, LocalDate vaccinationDate, LocalDate expirationDate) {
        this.insured = insured;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }

   /* public Vaccination(Insured insured, Doctor doctor, LocalDate vaccinationDate, LocalDate expirationDate) {
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }*/



    //getters
    public Insured getInsured() {return insured;}

   // public Doctor getDoctor() {return doctor;}

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
