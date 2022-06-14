package com.accenuture.project.part2.Team1part2.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Timeslot {

    /* TA THELEI NA TA PSAXNEI ME SIGKEKRIMENI SEIRA IMEROMINIAS OPOTE DEN NOMIZW NA MAS KANEI I LOCAL DATE OPOTE TO
                KANW KANONIKA
     */

   // private int day;
   // private int month;
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

    public int timeslotCode; /////////// for doctor vaccination  kai na to doume genika ama xreiazetai na to prostesoume

    private static int addTimeslotCode=0;

    private boolean reserved =false;


    //constructor


    public Timeslot(LocalDate dateOfAppointment, LocalTime timeOfAppointment, int startMinute, int endMinute, Doctor doctor) {
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfAppointment = timeOfAppointment;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
        timeslotCode= ++ addTimeslotCode;  // kathe fora pou tha dimiourgeitai ena timeslot tha auksanetai to timeslot code kata ena
                //prwta auksanoume kai meta arxeiopoioume
    }

    public int getTimeslotCode() {
        return timeslotCode;
    }

    public void setTimeslotCode(int timeslotCode) {
        this.timeslotCode = timeslotCode;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public LocalTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(LocalTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public boolean isReserved() { return reserved; }

    public void reserve() { this.reserved = true; }

    public void unReserve() { this.reserved = false; }


}
