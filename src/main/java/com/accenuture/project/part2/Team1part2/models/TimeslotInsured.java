package com.accenuture.project.part2.Team1part2.models;

public class TimeslotInsured {  //created to make a reservation with one @Body

     Insured insured;
     Timeslot timeslot;

    public TimeslotInsured(Insured insured, Timeslot timeslot) {
        this.insured = insured;
        this.timeslot = timeslot;
    }

    //getters
    public Insured getInsured() {
        return insured;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

}
