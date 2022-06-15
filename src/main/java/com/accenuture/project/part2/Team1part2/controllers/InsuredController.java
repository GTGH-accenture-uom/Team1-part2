package com.accenuture.project.part2.Team1part2.controllers;

import com.accenuture.project.part2.Team1part2.models.Insured;
import com.accenuture.project.part2.Team1part2.services.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuredController{

    @Autowired
    private InsuredService insuredService;

    @PostMapping("/insured")
    public String createInsuredPerson(@RequestBody Insured insured){
      return insuredService.createInsured(insured);
    }

    @GetMapping("/insured")
    public List<Insured> ShowInsuredList(){
        return insuredService.getInsured();
    }

}

