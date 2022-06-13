package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.Doctor;
import com.accenuture.project.part2.Team1part2.models.Reservation;
import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.models.Insured;
import com.accenuture.project.part2.Team1part2.services.ReservationsService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    // CREATNG RESERVATION
    //http://localhost:8181/reservation?amka=3433566&timeslot=t1s&doctor=doctor
    @PostMapping(path= "/reservation")
    public String makeReservation(@RequestParam(value = "amka") long amka,
                                   @RequestBody Timeslot timeslot,
                                   @RequestBody Doctor doctor){

        reservationsService.createReservation(amka,timeslot,doctor);
        return "Reservation created successfully!";
    }

    // returns all upcoming reservations
    @GetMapping(path="/reservation")
    public List<Reservation> showUpcomingReservations(){

        return reservationsService.upcomingReservations();
    }

    //return reservations of specific day by giving body of local date

    //@JsonFormat(pattern="yyyy-MM-dd")

    //http://localhost:8080/reservation/day?date=
    @GetMapping(path ="/reservation/day")
    public List<Reservation> showReservationsOfDay(@RequestParam(value= "date") LocalDate date){
        return reservationsService.reservationsOfDay(date);

    }


    // UPDATING RESERVATION
    @PutMapping(path= "/reservation")
    public String changeReservation(@RequestBody Reservation reservation,
                                         @RequestBody Timeslot timeslot,
                                         @RequestBody Doctor doctor) {

            return reservationsService.updateReservation(reservation,timeslot,doctor);

    }





}
