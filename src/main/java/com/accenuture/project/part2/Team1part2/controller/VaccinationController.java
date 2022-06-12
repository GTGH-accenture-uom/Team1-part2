package com.accenuture.project.part2.Team1part2.controller;

import com.accenuture.project.part2.Team1part2.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;




    //CHECKING VACCINATION STATUS////////////////
    //http://localhost:8080/vaccination/12125690876
    @GetMapping(path = "/vaccination/{defAmka}")
    public String checkingVaccinationStatus(@RequestParam(value = "defAmka") long amka){

        return vaccinationService.checkVaccinationStatus(vaccinationService.getVaccinations(), amka);

    }
}
