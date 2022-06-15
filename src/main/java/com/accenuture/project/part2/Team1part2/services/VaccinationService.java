package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Vaccination;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccinationService {

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    List<Vaccination> vaccinations;

    // checking vaccination status
    public String checkVaccinationStatus( List<Vaccination> vaccinations, Long defAmka){

        for(Vaccination v : vaccinations) {

            if (v.getInsured().getAmka() == defAmka & v.getExpirationDate().isAfter(LocalDate.now()))
            {
               return "You have vaccine coverage! Expires at: " + v.getExpirationDate();
            }
            else if(!(v.getInsured().getAmka()==defAmka)){
                throw new IllegalStateException("Their is no person insured with the AMKA you've submitted!");
            }
            else if(v.getInsured().getAmka()==defAmka & v.getExpirationDate().isBefore(LocalDate.now())) {
                return "You don't have vaccine coverage! Your vaccine coverage expired at: " + v.getExpirationDate();
            }

        }

      return "";

    }
}
