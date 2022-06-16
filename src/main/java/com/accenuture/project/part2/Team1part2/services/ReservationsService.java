package com.accenuture.project.part2.Team1part2.services;

//import com.accenuture.project.part2.Team1part2.models.*;
import com.accenuture.project.part2.Team1part2.models.*;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.accenuture.project.part2.Team1part2.Team1part2Application.*;

@Service
public class ReservationsService{

    Insured testerInsured;
    Timeslot testerTimeslot;

    private List<Reservation> reservationList = new ArrayList<>(reservations);

    //make a reservation
    public String createReservation(TimeslotInsured timeslotInsured) {

        int i,y;
        for(i=0;i< insuredList.size();i++) {
            if(insuredList.get(i).equals(timeslotInsured.getInsuredPerson())){ //(ind.getAmka() == timeslotInsured.getInsuredPerson().getAmka()) {
                testerInsured = insuredList.get(i);

            }
//            else if(!insuredList.get(i).equals(timeslotInsured.getInsuredPerson())){
//                return "The insured person you have inouted doenst exist";
//            }
        }
        for(y=0;y< timeslots1.size();y++){
            if(timeslots1.get(i).equals(timeslotInsured.getTimeslotTim())){
                testerTimeslot=timeslots1.get(i);
                timeslots1.get(i).reserve(); // to timeslot me to opoio ginetai to reservation ginetai reserved
            }
//            else{
//                return "The timeslot you have chosen doesnt exist ";
//            }

        }

        Reservation res = new Reservation(testerInsured, testerTimeslot);
        reservationList.add(res);


        return "Reservation created successfully!!!";

    }


//if insured person given exists
    //  if (insuredList.contains(timeslotInsured.getInsured()) && !timeslotInsured.getTimeslot().isReserved()) {


//       } else {
//            if (!insuredList.contains(timeslotInsured.getInsured())) {   //if insured was not found
//                return "Didn't find insured!!!";
//            } else if (timeslotInsured.getTimeslot().isReserved()) {   //if timeslot is reserved
//                return "Timeslot is reserved!!!";
//            } else {
//                return "!!!!!!!!!ERROR!!!!!!!!!!!!!!";   //all other cases
//            }
//        }

    //}

    //returns all reservations
    public List<Reservation> getReservationList() {
        return reservationList;
    }
    List<Reservation> upcomingReservationsList = new ArrayList<>();
    // returns upcoming reservations
    public List<Reservation> upcomingReservations(){

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

    //update reservation
    public String updateReservation(ReservationTimeslotInsured reservationTimeslotInsured) {

        if (reservationList.contains(reservationTimeslotInsured.getInsured()) & reservationTimeslotInsured.getReservation1().
                getReservationsChanges() < 2) {

            reservationTimeslotInsured.getReservation1().increaseReservationsChanges();
            reservationList.remove(reservationTimeslotInsured.getReservation1());

            //We need a ReservationTimeslotInsured Class in ReservationsController
            return createReservation( reservationTimeslotInsured.getTimeslotInsured() );

        } else {
            if (!reservationList.contains(reservationTimeslotInsured.getInsured())) {
                return "Reservation given does not exist!";
            } else if (reservationTimeslotInsured.getReservation1().getReservationsChanges() >= 2) {
                return "You have already changed your appointment twice!";
            } else {
                return "!!!!!!ERROR!!!!!!";
            }
        }
    }

}