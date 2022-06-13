package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //http://localhost:8080/doctor?timeslotCode=1&amka=1234567899&expirationDate=27/7/24
    @PostMapping(path ="/doctor")
    public String declareVaccination(@RequestParam(value= " timeslotCode")  int timeslotCode,
                                     @RequestParam(value = "amka") long amka,
                                     @RequestParam(value = "expirationDate") LocalDate expirationDate){

        return doctorService.declarationOfVaccination(timeslotCode,amka,expirationDate);


    }


}
  //  Κωδικός χρονικής θυρίδας - timeslot
    //    • ΑΜΚΑ ασφαλισμένου
     //   • Διάρκεια κάλυψης (ημ. Λήξης)
