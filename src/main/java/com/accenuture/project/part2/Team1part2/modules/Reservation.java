package com.accenuture.project.part2.Team1part2.modules;

public class Reservation {

    private Insured insured;
    private Timeslot timeslot;

    private Doctor doctor; // gia to createReservatrion

    public Reservation(Insured insured, Timeslot timeslot) {
        this.insured = insured;
        this.timeslot = timeslot;
    }

    public Reservation() {

    }

    //gia to create Reservation
    public Reservation(Insured insured, Timeslot timeslot, Doctor doctor) {
        this.insured = insured;
        this.timeslot = timeslot;
        this.doctor = doctor;
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
