package com.accenuture.project.part2.Team1part2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VaccinationCenter implements Serializable {

    private String code;
    private String address;

    List<Timeslot> timeslots = new ArrayList<>();

    public VaccinationCenter(String code, String address, List<Timeslot> timeslots) {
        this.code = code;
        this.address = address;
        this.timeslots = timeslots;
    }

    //getters
    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

}
