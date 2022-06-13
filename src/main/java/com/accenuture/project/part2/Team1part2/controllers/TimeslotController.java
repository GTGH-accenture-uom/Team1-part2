package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    // CHECKS IF TIMESLOT WITH SPECIFIC DATE IS FREE OR NOT
    //http://localhost:8080/timeslot?day=01&month=2&year=2022
    @GetMapping(path="/timeslot")
    public String searchTimeslotByDate(@RequestParam(value = "day") int day,
                                         @RequestParam(value = "month") int month,
                                         @RequestParam(value = "year") int year){

         return timeslotService.getTimeslotByDate(day, month, year);

    }
}
