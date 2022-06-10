package com.accenuture.project.part2.Team1part2.modules;

import java.time.LocalTime;

public class Timeslot {

    /* TA THELEI NA TA PSAXNEI ME SIGKEKRIMENI SEIRA IMEROMINIAS OPOTE DEN NOMIZW NA MAS KANEI I LOCAL DATE OPOTE TO
                KANW KANONIKA
     */

    private int day;
    private int month;
    private int year;
    // instead of the above we could do :
    //private LocalDate date_of_appointment;

    //private int hour;
    //private int minutes;
    //instead of the above we could use:
    private LocalTime time_of_appointment;

    private int startMinute;
    private int endMinute;
    private Doctor doctor ;

    //constructor

    public Timeslot(int day, int month, int year, LocalTime time_of_appointment, int startMinute, int endMinute, Doctor doctor) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.time_of_appointment = time_of_appointment;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalTime getTime_of_appointment() {
        return time_of_appointment;
    }

    public void setTime_of_appointment(LocalTime time_of_appointment) {
        this.time_of_appointment = time_of_appointment;
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
}
