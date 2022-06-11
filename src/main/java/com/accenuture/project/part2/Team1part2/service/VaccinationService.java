package com.accenuture.project.part2.Team1part2.service;

import com.accenuture.project.part2.Team1part2.modules.Insured;
import com.accenuture.project.part2.Team1part2.modules.Vaccination;
import org.springframework.beans.factory.annotation.Value;
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
            if (v.getInsured().getAmka()==defAmka & v.getExpirationDate().isAfter(LocalDate.now()))
            {
               return "You have vaccine coverage!";

            }
            else if(!(v.getInsured().getAmka()==defAmka)){
                System.out.println("Their is no person insured with the AMKA you've submitted! ");
            }
        }

        return "You don't have vaccine coverage!";

    }
}
