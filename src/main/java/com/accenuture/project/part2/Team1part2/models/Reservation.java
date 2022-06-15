package com.accenuture.project.part2.Team1part2.models;


public class Reservation {


    private Insured insured;


   private Timeslot timeslot;

    private Doctor doctor; // gia to createReservatrion*/

    private int reservationsChanges=0; // to kanei set kathe fora wste na krataei otan ginei allagi akomi kai otan bgei
                                    // apo update// blepe reservation service

    /*public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }*/



    public Reservation(Insured insured, Timeslot timeslot) {
        this.insured = insured;
        this.timeslot = timeslot;
    }

    public Reservation() {

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

    public int getReservationsChanges() {
        return reservationsChanges;
    }

    public void setReservationsChanges(int reservationsChanges) {
        this.reservationsChanges = reservationsChanges;
    }
}
