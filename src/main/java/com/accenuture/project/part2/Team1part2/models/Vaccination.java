package com.accenuture.project.part2.Team1part2.models;

import java.time.LocalDate;

public class Vaccination {

    private Insured insured;
    private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    public Vaccination(Insured insured, Doctor doctor, LocalDate vaccinationDate, LocalDate expirationDate) {
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }

    //////////constructor for method declarationOfVaccination in DoctorService class
    public Vaccination(int timeslotCode, long amka, LocalDate expirationDate) {

    }

    //setters
    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    //getters
    public Insured getInsured() {return insured;}

    public Doctor getDoctor() {return doctor;}

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return  "Vaccination[ " +
                "Vaccination Date: " + vaccinationDate +
                ", Expiration at: " + expirationDate +
                " ]";
    }

}
