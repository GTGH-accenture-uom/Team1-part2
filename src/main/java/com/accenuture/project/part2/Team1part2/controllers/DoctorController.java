package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.DeclaredVaccination;
import com.accenuture.project.part2.Team1part2.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping(path="/doctor")
    public String declareVaccination(@RequestBody DeclaredVaccination declaredVaccination) {

        return doctorService.declarationOfVaccination(declaredVaccination);
    }

    @GetMapping(path ="/doctor")
    public List<DeclaredVaccination> getAllDeclaredVaccination(){
        return doctorService.getListOfDeclaredVaccinations();

    }

}

