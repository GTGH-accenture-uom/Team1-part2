package com.accenuture.project.part2.Team1part2.models;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reservation {


    private Insured insured;


    private Timeslot timeslot;

    private Doctor doctor; // gia to createReservatrion

    private int reservationsChanges; // to kanei set kathe fora wste na krataei otan ginei allagi akomi kai otan bgei
                                    // apo update// blepe reservation service

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getReservationsChanges() {
        return reservationsChanges;
    }

    public void setReservationsChanges(int reservationsChanges) {
       this.reservationsChanges = reservationsChanges;
    }

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
