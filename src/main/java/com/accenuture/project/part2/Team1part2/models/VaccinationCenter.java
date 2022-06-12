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

    //setters
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setTimeslots(List<Timeslot> timeslots) {
//        this.timeslots = timeslots;
//    }

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


    @Override
    public String toString() {

        String results = "";
        int id=1;

        for(Timeslot t : timeslots){
            if(!t.isReserved())
            {
                results += "\n" + id++ +". "+ t.toString();
            }
            else
            {
                results += "\n" + id++ +". "+ "- - - Reserved - - -";
            }
        }

        return  "VaccinationCenter[ "+ "Code: " + code + ", Address: " + address + " ]" + results + "\n";
    }


}
