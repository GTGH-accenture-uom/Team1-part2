package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.*;
import com.accenuture.project.part2.Team1part2.services.ReservationsService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReservationsController{

    @Autowired
    private ReservationsService reservationsService;

    //make a reservation
    @PostMapping(path= "/reservation")
    public String makeReservation(@RequestBody TimeslotInsured timeslotInsured){
        return reservationsService.createReservation(timeslotInsured);
    }

    //returns all upcoming reservations
    @GetMapping(path="/reservation")
    public List<Reservation> showUpcomingReservations(){

        return reservationsService.upcomingReservations();
    }

    //gets all reservations
    @GetMapping(path="/reservation/all")
    public List<Reservation> reservationsAll(){

        return reservationsService.getReservationList();
    }

    //return reservations of specific day by inputting day, month,year
    //http://localhost:8080/reservation/day?day=31&month=08&year=2022
    @GetMapping(path="/reservation/day")
    public List<Reservation> showReservationsOfDay(@RequestParam(value = "day") int day,
                                                   @RequestParam(value = "month") int month,
                                                   @RequestParam(value = "year") int year) {
        return reservationsService.reservationsOfDay(day, month, year);
    }


    //update reservation
    @PutMapping(path="/editReservation")
    public String changeReservation(@            ){

            return reservationsService.updateReservation(reservationTimeslot);

    }

}
