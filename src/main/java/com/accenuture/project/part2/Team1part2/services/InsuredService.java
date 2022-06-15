package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Insured;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.accenuture.project.part2.Team1part2.Team1part2Application.insuredList;

@Service
public class InsuredService {

    public String createInsured(Insured insured) {

        if (!insuredList.contains(insured)) {
            insuredList.add(insured);
            return "Insured created successfully!!!";
        } else {
            throw new IllegalStateException("Insured already exists");
        }

    }

    public List<Insured> getInsured() {
        return insuredList;
    }

}
