package com.accenuture.project.part2.Team1part2.services;

//import com.accenuture.project.part2.Team1part2.models.*;
import com.accenuture.project.part2.Team1part2.models.*;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.accenuture.project.part2.Team1part2.Team1part2Application.*;

@Service
public class ReservationsService {

    private Insured testerInsured;
    private Timeslot testerTimeslot;

    private List<Reservation> reservationList = new ArrayList<>(reservations);


    // Creating reservation
    public String createReservation(long amka, int timeslotcode) {

        int i, y;
        for (i = 0; i < insuredList.size(); i++) {
            if (insuredList.get(i).getAmka() == amka) { //(ind.getAmka() == timeslotInsured.getInsuredPerson().getAmka()) {
                this.testerInsured = insuredList.get(i);

            }
//            else if(!insuredList.get(i).equals(timeslotInsured.getInsuredPerson())){
//                return "The insured person you have inouted doenst exist";
//            }
        }
        for (y = 0; y < timeslots1.size(); y++) {
            if (timeslots1.get(y).getTimeslotCode() == timeslotcode) {
                this.testerTimeslot = timeslots1.get(y);
                timeslots1.get(y).reserve(); // to timeslot me to opoio ginetai to reservation ginetai reserved
            }
//            else{
//                return "The timeslot you have chosen doesnt exist ";
//            }

        }

        Reservation res = new Reservation(testerInsured, testerTimeslot);
        reservationList.add(res);


        return "Reservation created successfully!!!";

    }


    //returns all reservations
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    List<Reservation> upcomingReservationsList = new ArrayList<>();

    // returns upcoming reservations
    public List<Reservation> upcomingReservations() {

        //create the list that will hold the upcoming reservations after the check


        Reservation checkUpcomingReservation = null; // used to check if the reservation is upcoming or has already happened

        if (!reservationList.isEmpty()) {
            for (int i = 0; i < reservationList.size(); i++) {

                checkUpcomingReservation = reservationList.get(i);

                // if date of reservation is after todays date (=> upcoming), then add to list of upcoming reservations
                if (checkUpcomingReservation.getTimeslot().getDateOfAppointment().isAfter(LocalDate.now())) {
                    upcomingReservationsList.add(checkUpcomingReservation);
                }
            }
        }

        return upcomingReservationsList;
    }

    //creates list that will hold reservations at specific date
    List<Reservation> reservationDayList = new ArrayList<>();

    // returns a list of reservations at specific date
    public List<Reservation> reservationsOfDay(int day, int month, int year) {


        Reservation checkReservation = null;   //used to  hold the days reservsation and then pass it in the list

        if (!reservationList.isEmpty()) {

            for (int i = 0; i < reservationList.size(); i++) {

                // ckecks if the reservation in the list of reservations has a specific date in its timeslot

                if (reservationList.get(i).getTimeslot().getDateOfAppointment().getDayOfMonth() == day &&
                        reservationList.get(i).getTimeslot().getDateOfAppointment().getMonthValue() == month &&
                        reservationList.get(i).getTimeslot().getDateOfAppointment().getYear() == year) {// ckecks if ths reservation in the list
                    checkReservation = reservationList.get(i);

                    reservationDayList.add(checkReservation);

                }
            }
        }
        return reservationDayList;
    }

    //uodating reservation by giving new desired timeslotcode and inputing the previous reservation
    public String editReservation(int newtimeslotCode, Reservation reservation){

        Timeslot checking=null;

        Reservation updatedReservation;
        if(reservations.contains(reservation) && reservation.getReservationsChanges()<2){
            reservation.increaseReservationsChanges();
            reservations.remove(reservation);

            for(Timeslot tm: timeslots1){
                if(timeslots1.contains(newtimeslotCode)){
                    checking =tm;
                }
                else{
                    return " Their is no available timeslot with that timslote code";
                }
            }


            updatedReservation=new Reservation(reservation.getInsured(),checking);

            reservations.add(updatedReservation);

        }
        if (!reservationList.contains(reservation)) {
            return "Reservation given does not exist!";
        }
        if (reservation.getReservationsChanges() >= 2) {
            return "You have already changed your appointment twice!";
        }

        return " Error!!";
    }
}






