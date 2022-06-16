package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.DeclaredVaccination;
import com.accenuture.project.part2.Team1part2.models.Insured;
import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.models.Vaccination;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.accenuture.project.part2.Team1part2.Team1part2Application.insuredList;
import static com.accenuture.project.part2.Team1part2.Team1part2Application.timeslots1;

@Service
public class VaccinationService {


    List<Vaccination> vaccinations =new ArrayList<>();
    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    Insured insured1;       // only use in this method declare vaccination
    Timeslot timeslotMethod;

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }



    // checking vaccination status
    public String checkVaccinationStatus( Long defAmka){

        for(Vaccination v : vaccinations) {

            if (v.getInsured().getAmka() == defAmka & v.getExpirationDate().isAfter(LocalDate.now()))
            {
               return "You have vaccine coverage! Expires at: " + v.getExpirationDate();
            }
            else if(!(v.getInsured().getAmka()==defAmka)){
                throw new IllegalStateException("Their is no person insured with the AMKA you've submitted!");
            }

        }
        return "You don't have vaccine coverage!";
    }


    public String vaccinationDeclared(DeclaredVaccination declaredVaccination) {

        for(Insured ins:insuredList) {
            if (ins.getAmka() == declaredVaccination.getAmka()) {
                insured1 = ins;
            }
        }

        for(Timeslot tsm: timeslots1){
            if(tsm.getTimeslotCode()==  declaredVaccination.getTimeslotCode1()){
                timeslotMethod=tsm;
            }
        }

        Vaccination vaccination=new Vaccination(insured1, timeslotMethod.getDateOfAppointment(),
                declaredVaccination.getExpirationDate() );

        vaccinations.add(vaccination);
        return "Vaccination Declared Successfully!";


    }
}