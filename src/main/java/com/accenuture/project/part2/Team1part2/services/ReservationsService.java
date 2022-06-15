package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {



    private List<Insured> insuredList = new ArrayList<>();
    private List<Reservation> reservationList = new ArrayList<>();


// CREATES RESERVATION AND PUTS IT IN LIST RESERVATION LIST

    public String createReservation(TimeslotInsured timeslotInsured) {

        Insured insured1 = null;

        for (Insured insuredPerson : insuredList) {


            if (!timeslotInsured.getTimeslot().isReserved()) { // elegxei oti to timeslot pou epelekse den einai reserved

                if (insuredPerson.getAmka() == timeslotInsured.getInsured().getAmka()) { // if an insured person with this amka exists then:
                    insured1 = insuredPerson;
                }
            }
        }
        Reservation resv = new Reservation(insured1, timeslotInsured.getTimeslot());

        timeslotInsured.getTimeslot().reserve();// kanei reserve to timeslot pou xrisimopoiithike gia to reservation

        reservationList.add(resv);

        return "Reservation Created Successfully";


    }

    // RETURNS LIST OF RESERVATIONS
    public List<Reservation> getReservationList() {
        return reservationList;
    }



    // returns a list of upcoming reservations
    public List<Reservation> upcomingReservations() {

        //create the list that will hold the upcoming reservations after the check

        List<Reservation> upcomingReservationsList = new ArrayList<>();

        Reservation checkUpcomingReservation=null; // used to check the if the reservation is upcoming or has already happened
        //for (Reservation res : reservationList) {


        if (!reservationList.isEmpty()) {
            for (int i = 0; i < reservationList.size(); i++) {
                checkUpcomingReservation = reservationList.get(i);
                // if date of reservation is after todays date(diladi upcoming) than add to list of upcomming reservations
                if (checkUpcomingReservation.getTimeslot().getDateOfAppointment().isAfter(LocalDate.now())) { // if date of reservation is in the future

                    upcomingReservationsList.add(checkUpcomingReservation);
                }
            }
        }
        return upcomingReservationsList;
    }

    // returns a list of reservations of a specific date
    public List<Reservation> reservationsOfDay(int day,int month,int year) {

        List<Reservation> reservationDayList = new ArrayList<>();// creates list that will hold reservations of specific date
        Reservation checkReservation;   // used to  hold the days reservsation and then pass it in the list
        if (!reservationList.isEmpty()) {
            for (int i = 0; i < reservationList.size(); i++) {

                // ckecks if ths reservation in the list of reservations has a specific date in its timeslot

                if (reservationList.get(i).getTimeslot().getDateOfAppointment().getDayOfMonth()==day&&
                        reservationList.get(i).getTimeslot().getDateOfAppointment().getMonthValue()==month&&
                        reservationList.get(i).getTimeslot().getDateOfAppointment().getYear()==year){// ckecks if ths reservation in the list
                    checkReservation = reservationList.get(i);

                    reservationDayList.add(checkReservation);

                }
            }
        }
        return reservationDayList;
    }
}



    /*public String updateReservation(Reservation reservation, Timeslot timeslot, Doctor doctor) {



        int counter = reservation.getReservationsChanges();
        counter = 0;

        Reservation reservation1 = null;
        for (Insured insuredPerson : insuredList) {
            while (reservation.getReservationsChanges() < 2) {

                if (reservationList.contains(reservation.getInsured())) { // ama iparxei idi klesimeno rantevou me idio insuured

                     reservationList.remove(reservation); //// prin dilwnei kainourio  reservation diagrafei ton proigoume
                    reservation1 = createReservation(reservation.getInsured().getAmka(), timeslot, doctor);


                    if (reservation1 != null) {   // efoson ginei o emboliasmos  tote na auksithei o counter alliws oxi se periptwsi sfalmatoa
                        counter++;
                        reservation.setReservationsChanges(counter);// wste na enimerwnetai gia kathe insured poses allages ekane
                        return "Reservation updated!";
                    } else {
                        throw new RuntimeException("You have already changed your appointment twice");
                    }
                }
            }
        }
        return " ";
    }*/

/// updating reservation
   /* public Reservation updateReservation(ReservationTimeslot reservationTimeslot) {
        Insured insured1 = null;

        Reservation reservation1;

        for (Insured insuredPerson : insuredList) {

            if (insuredPerson.getAmka() == reservationTimeslot.getReservation().getInsured().getAmka()) {
                reservation1 = createReservation(new TimeslotInsured(reservationTimeslot.getReservation().getInsured()),reservationTimeslot.getReservation().getTimeslot())
               int counter= reservation.getReservationsChanges()++;
            }
            else{
                throw new IllegalStateException("There is no person insured with that amka");
            }
        }

        return reservation;
    }
}


*/
