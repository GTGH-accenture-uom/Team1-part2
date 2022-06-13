package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Insured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredService {

    List<Insured> insuredList = new ArrayList<>();

    public String createInsured(Insured insured){
        //if(insuredList.contains(insured)) {
        if (!insuredList.contains(insured)) {
            insuredList.add(insured);
            return "Insured created successfully!";
        } else {
            throw new IllegalStateException("Insured already exists");
        }


    }

    public List<Insured> getInsured() {
        return insuredList;
    }
}
