package com.accenuture.project.part2.Team1part2.models;


import java.io.Serializable;

public class Reservation implements Serializable {

    private Insured insured;

    private Timeslot timeslot;

    private int reservationsChanges=0;

    public Reservation(Insured insured, Timeslot timeslot) {
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

    public int getReservationsChanges() {
        return reservationsChanges;
    }


//    private Doctor doctor; // needed for createReservation?
//
//    public Doctor getDoctor() {
//        return doctor;
//    }

}
