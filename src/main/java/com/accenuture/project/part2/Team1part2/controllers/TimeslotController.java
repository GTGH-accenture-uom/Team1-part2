package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    //CREATING TIMESLOTS WITH BODY
    @PostMapping("/timeslot")
    public String makeTimeslots(@RequestBody Timeslot timeslot){

         timeslotService.createTimeslots(timeslot);
        return "Timeslot created!";
    }

    //GETTING TIMESLOTS THAT HAVE BEEN CREATED

    @GetMapping(path = "/timeslot/all")
    public List<Timeslot> showListOfAllTimeslotsCreated(){

        return timeslotService.getTimeslots();
    }


    // CHECKS IF day has free timeslots
    //http://localhost:8080/timeslot?day=01&month=2&year=2022
    @GetMapping(path="/timeslot")
    public String searchTimeslotBAvailability(@RequestParam(value = "day") int day,
                                         @RequestParam(value = "month") int month,
                                         @RequestParam(value = "year") int year){

         return timeslotService.checkTimeslotAvailability(day, month, year);

    }

    /// DISPLAYS THE FREE TIMESLOTS OF SPECIFIC DATE
    //http://localhost:8080/timeslot?day=01&month=2&year=2022
    @GetMapping(path="/timeslot/available")
    public List<Timeslot> showAvailableTimeslots(@RequestParam(value = "day") int day,
                                            @RequestParam(value = "month") int month,
                                            @RequestParam(value = "year") int year){

        return timeslotService.showAvailableTimeslots(day, month, year);

    }


}
