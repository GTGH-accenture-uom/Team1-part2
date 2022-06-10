package com.accenuture.project.part2.Team1part2.modules;

import java.time.LocalDate;

public class Vaccination {

    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    public Vaccination(LocalDate vaccinationDate, LocalDate expirationDate) {
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
