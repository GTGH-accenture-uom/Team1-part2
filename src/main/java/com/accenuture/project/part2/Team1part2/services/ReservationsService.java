package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Doctor;
import com.accenuture.project.part2.Team1part2.models.Insured;
import com.accenuture.project.part2.Team1part2.models.Reservation;
import com.accenuture.project.part2.Team1part2.models.Timeslot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {

    List<Insured> insuredList=new ArrayList<>();


    public Reservation createReservation(long amka, Timeslot timeslot, Doctor doctor) {

        Insured insured1 = null;

       for(Insured insuredPerson: insuredList){

           if(insuredPerson.getAmka()==amka){
                insured1= insuredPerson;
           }
       }
        Reservation resv= new Reservation(insured1,timeslot,doctor);

        return resv;


    }
/// updateing reservation
    public Reservation updateReservation(long amka, Timeslot timeslot, Doctor doctor) {
        Insured insured1 = null;


        Reservation reservation = null;
        for (Insured insuredPerson : insuredList) {

            if (insuredPerson.getAmka() == amka) {
                reservation = createReservation(amka, timeslot, doctor);
            }
            else{
                System.out.println("There is no person insured with that amka");
            }
        }

        return reservation;
    }
}
