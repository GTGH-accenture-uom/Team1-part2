package com.accenuture.project.part2.Team1part2.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Timeslot implements Serializable {

    //private int day;
    //private int month;
    //private int year;
    //instead of the above we could do :
    private LocalDate dateOfAppointment;

    //private int hour;
    //private int minutes;
    //instead of the above we could use:
    private LocalTime timeOfAppointment;

    private int startMinute;
    private int endMinute;
    private Doctor doctor ;

    public int timeslotCode;
    private static int addTimeslotCode = 0;

    private boolean reserved = false;

    //constructor
    public Timeslot(LocalDate dateOfAppointment, LocalTime timeOfAppointment, int startMinute, int endMinute, Doctor doctor) {
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfAppointment = timeOfAppointment;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;

        timeslotCode = ++ addTimeslotCode;
    }

    public boolean isReserved() { return reserved; }

    public void reserve() { this.reserved = true; }

    public void unReserve() { this.reserved = false; }

    //getters
    public int getTimeslotCode() {
        return timeslotCode;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public LocalTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public Doctor getDoctor() {
        return doctor;
    }

}
