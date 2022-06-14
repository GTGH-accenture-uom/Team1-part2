package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Insured;
import com.accenuture.project.part2.Team1part2.models.Reservation;
import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
            ReservationsService reservationsService;

    Insured insured;// gonna get amka

    Timeslot timeslot ; // gonna get timeslotCode

    List<Vaccination> listOfDeclaredVaccinations=new ArrayList<>();

    public String declarationOfVaccination(int timeslotCode, long amka, LocalDate expirationDate) {

        Vaccination vaccination; // creating vaccination

        vaccination= new Vaccination( timeslotCode,amka,expirationDate);

        listOfDeclaredVaccinations.add(vaccination);
        // afou ginei o emboliasmos diafrafetai to reservation pou eixe kanei
        for(Reservation r: reservationsService.getReservationList()){
            if(r.getInsured().getAmka()== amka){
                r.getTimeslot().unReserve();
                reservationsService.getReservationList().remove(r);
                break;
            }
        }

        return "Vaccination declared successfully!";
    }
}

