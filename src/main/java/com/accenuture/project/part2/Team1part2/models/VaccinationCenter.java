package com.accenuture.project.part2.Team1part2.models;

import java.util.ArrayList;
import java.util.List;

public class VaccinationCenter {
    private String code;
    private String address;

    List<Timeslot> timeslots = new ArrayList<>();

    public VaccinationCenter(String code, String address, List<Timeslot> timeslots) {
        this.code = code;
        this.address = address;
        this.timeslots = timeslots;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }
}
