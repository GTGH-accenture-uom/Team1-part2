package com.accenuture.project.part2.Team1part2.controller;

import com.accenuture.project.part2.Team1part2.modules.Timeslot;
import com.accenuture.project.part2.Team1part2.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

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
