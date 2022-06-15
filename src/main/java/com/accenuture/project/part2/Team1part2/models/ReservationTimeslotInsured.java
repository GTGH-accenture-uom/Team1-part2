package com.accenuture.project.part2.Team1part2.models;

public class ReservationTimeslotInsured { //created to edit a reservation with one @Body

    private Reservation reservation;
    private Timeslot timeslot;
    private Insured insured;

    private TimeslotInsured timeslotInsured;

    //constructor
    public ReservationTimeslotInsured(Reservation reservation, Timeslot timeslot, Insured insured) {
        this.reservation = reservation;
        this.timeslot = timeslot;
        this.insured = insured;

        this.timeslotInsured = new TimeslotInsured(insured, timeslot);
    }

    //getters
    public Reservation getReservation() {
        return reservation;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public Insured getInsured() {
        return insured;
    }

    public TimeslotInsured getTimeslotInsured() {
        return timeslotInsured;
    }
}
