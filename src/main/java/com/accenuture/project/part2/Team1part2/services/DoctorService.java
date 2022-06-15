package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    ReservationsService reservationsService;

    List<DeclaredVaccination> listOfDeclaredVaccinations = new ArrayList<>();

    //declare a vaccination, then unreserve timeslot and remove reservation from their lists
    public String declarationOfVaccination(DeclaredVaccination declaredVaccination) {

        declaredVaccination = new DeclaredVaccination( declaredVaccination.getTimeslotCode(), declaredVaccination.getAmka(),
                declaredVaccination.getExpirationDate());

        listOfDeclaredVaccinations.add(declaredVaccination);

        for(Reservation r : reservationsService.getReservationList()){
            if(r.getInsured().getAmka() == declaredVaccination.getAmka()){
                r.getTimeslot().unReserve();
                reservationsService.getReservationList().remove(r);
                break;
            }
        }

        return "Vaccination declared successfully!!!";

    }

    public List<DeclaredVaccination> getListOfDeclaredVaccinations(){
        return listOfDeclaredVaccinations;
    }

}

