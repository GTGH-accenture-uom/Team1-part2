package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.DeclaredVaccination;
import com.accenuture.project.part2.Team1part2.models.Vaccination;
import com.accenuture.project.part2.Team1part2.services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    // shows all vaccinations
    @GetMapping(path="/vaccination")
    public List<Vaccination> getAllVaccinatons() {
        return vaccinationService.getVaccinations();
    }


    //check vaccination status with amka given
    //http://localhost:8080/vaccination/12125690876
    @GetMapping(path = "/vaccination/get")
    public String checkingVaccinationStatus(@RequestParam(value = "Amka") long amka){

        return vaccinationService.checkVaccinationStatus(amka);
    }



    //Doctor Declares Vaccination by inputing timeslot, amka of insured, vaccination expiration date

    //http://localdate:8080/vaccination/declaration
    @PostMapping(path= "/vaccination/declaration")
    public String declaringVaccination(@RequestBody DeclaredVaccination declaredVaccination){

        return vaccinationService.vaccinationDeclared(declaredVaccination);

    }



}
