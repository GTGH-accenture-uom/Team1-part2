package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.services.DoctorService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController

public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //http://localhost:8080/doctor?timeslotCode=1&amka=1234567899&expirationDate=27/7/24
    @PutMapping(path ="/doctor")
    public String declareVaccination(@RequestParam(value= " timeslotCode")  int timeslotCode,
                                     @RequestParam(value = "amka") long amka,
                                     @RequestParam("localDate")
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDate){

        return doctorService.declarationOfVaccination(timeslotCode,amka,expirationDate);


    }
// have to check local date in postman how to call

    /*@PutMapping(path ="/doctor/{timeslotCode}/{amka}/{expirationDate}")
    public String declareVaccination(@PathVariable(value= "timeslotCode")  int timeslotCode,
                                     @PathVariable(value = "amka") long amka,
                                     @PathVariable @DateTimeFormat(pattern = "yyyyy-MM-dd") LocalDate expirationDate)
                                     //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDate)
                                     {

        return doctorService.declarationOfVaccination(timeslotCode, amka, expirationDate);
    }*/

   /* @PostMapping(path ="/doctor/{timeslotCode}/{amka}")
    public String declareVaccination(@PathVariable(value= "timeslotCode")  int timeslotCode,
                                     @PathVariable(value = "amka") long amka,
                                     @RequestBody LocalDate expirationDate)
                                      {

        return doctorService.declarationOfVaccination(timeslotCode, amka, expirationDate);
    }*/

}

