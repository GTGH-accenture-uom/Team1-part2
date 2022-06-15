package com.accenuture.project.part2.Team1part2.models;

public class TimeslotInsured {  //created to make a reservation with one @Body


     Insured insured;
     Timeslot timeslot;

    //////////////// na to kanoume alliws na min dimiourgountai kainouria antikeimena alla na pairnei etoima
    public TimeslotInsured(Insured insured, Timeslot timeslot) {
        this.insured = insured;
        this.timeslot = timeslot;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }
}
