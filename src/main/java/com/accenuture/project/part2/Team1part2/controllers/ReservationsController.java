package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.Doctor;
import com.accenuture.project.part2.Team1part2.models.Reservation;
import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationsController {

    @Autowired
    ReservationsService reservationsService;

    // CREATNG RESERVATION
    //http://localhost:8181/reservation?amka=3433566&timeslot=t1s&doctor=doctor
    @PostMapping(path= "/reservation")
    public Reservation reservation(@RequestParam(value = "amka") long amka,
                                   @RequestBody Timeslot timeslot,
                                   @RequestBody Doctor doctor){

            return  reservationsService.createReservation(amka,timeslot,doctor);
    }

    // UPDATING RESERVATION
    @PutMapping(path= "/changeReservation")
    public Reservation changeReservation(@RequestParam(value = "amka") long amka,
                                         @RequestBody Timeslot timeslot,
                                         @RequestBody Doctor doctor) {
        int counterOfChanges = 0;
        Reservation reservationUpdated = null;
        while (counterOfChanges < 2) {          // gia na mporei na kanei update 3 fores mono

            reservationUpdated = reservationsService.updateReservation(amka, timeslot, doctor);
            counterOfChanges++;
        }
        System.out.println("You have made the maximum amount of cha");
        return reservationUpdated;
    }



}
