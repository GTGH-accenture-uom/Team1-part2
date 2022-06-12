package com.accenuture.project.part2.Team1part2.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Timeslot {

    //private int day;
    //private int month;
    //private int year;
    //instead of the above we could do:
    private LocalDate dateOfAppointment;

    //private int hour;
    //private int minutes;
    //instead of the above we could use:
    private LocalTime timeOfAppointment;

    private int startMinute;
    private int endMinute;
    private Doctor doctor;

    private boolean reserved = false;

    //constructor
    public Timeslot(LocalDate dateOfAppointment, LocalTime timeOfAppointment, int startMinute, int endMinute, Doctor doctor) {
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfAppointment = timeOfAppointment;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
    }

    //setters
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public void setStartMinute(int startMinute) {
//        this.startMinute = startMinute;
//    }
//
//    public void setEndMinute(int endMinute) {
//        this.endMinute = endMinute;
//    }
//
//    public void setDateOfAppointment(LocalDate date_of_appointment) {
//        this.dateOfAppointment = dateOfAppointment;
//    }
//
//    public void setTimeOfAppointment(LocalTime timeOfAppointment) {
//        this.timeOfAppointment = timeOfAppointment;
//    }

    //getters
    public int getStartMinute() {
        return startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public LocalTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    @Override
    public String toString() {
        return  "TimeSlot[ " +
                "Date:" + dateOfAppointment +
                ", Time:" + timeOfAppointment +
                ", startMin:" + startMinute +
                ", endMin:" + endMinute +
                ", " + doctor +
                " ]";
    }

    public boolean isReserved() { return reserved; }

    public void reserve() { this.reserved = true; }

    public void unReserve() { this.reserved = false; }

}
