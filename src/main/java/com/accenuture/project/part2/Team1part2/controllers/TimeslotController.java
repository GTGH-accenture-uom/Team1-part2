package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeslotController {

    @Autowired
    TimeslotService timeslotService;

    //http://localhost:8080/timeslot?day=01&month=2&year=2022
    @GetMapping(path="/searchTimeslot")
    public Timeslot searchTimeslotByDate(@RequestParam(value = "day") int day,
                                         @RequestParam(value = "month") int month,
                                         @RequestParam(value = "year") int year){

         return timeslotService.getTimeslotByDate(day, month, year);


    }
}
