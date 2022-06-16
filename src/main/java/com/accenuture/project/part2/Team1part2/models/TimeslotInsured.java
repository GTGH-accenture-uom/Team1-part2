package com.accenuture.project.part2.Team1part2.models;

public class TimeslotInsured {  //created to make a reservation with one @Body

    private Insured insuredPerson;
    private Timeslot timeslotTim;

    public TimeslotInsured(Insured insuredPerson, Timeslot timeslotTim) {
        this.insuredPerson = insuredPerson;
        this.timeslotTim = timeslotTim;
    }

    //getters
    public Insured getInsuredPerson() {
        return insuredPerson;
    }

    public Timeslot getTimeslotTim() {
        return timeslotTim;
    }

}
