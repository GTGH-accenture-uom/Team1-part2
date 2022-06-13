package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Insured;
import com.accenuture.project.part2.Team1part2.models.Timeslot;
import com.accenuture.project.part2.Team1part2.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {


    Insured insured;// gonna get amka

    Timeslot timeslot ; // gonna get timeslotCode

    List<Vaccination> listOfDeclaredVaccinations=new ArrayList<>();

    public String declarationOfVaccination(int timeslotCode, long amka, LocalDate expirationDate) {

        Vaccination vaccination; // creating vaccination

        vaccination= new Vaccination( timeslot.getTimeslotCode(),insured.getAmka(),expirationDate);

        listOfDeclaredVaccinations.add(vaccination);

        return "Vaccination declared successfully!";
    }
}
