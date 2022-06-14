package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Doctor;
import com.accenuture.project.part2.Team1part2.models.Insured;
import com.accenuture.project.part2.Team1part2.models.Reservation;
import com.accenuture.project.part2.Team1part2.models.Timeslot;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {



    private List<Insured> insuredList = new ArrayList<>();
    private List<Reservation> reservationList = new ArrayList<>();


// CREATES RESERVATION AND PUTS IT IN LIST RESERVATION LIST

    public Reservation createReservation(long amka, Timeslot timeslot) {

        Insured insured1 = null;

        for (Insured insuredPerson : insuredList) {

            if (insuredPerson.getAmka() == amka) { // if an insured person with this amka exists then:
                insured1 = insuredPerson;
            }
        }
        Reservation resv = new Reservation(insured1, timeslot, timeslot.getDoctor());// create reservation with that inured perspn and
        reservationList.add(resv);                                     // add him to list

        return resv;


    }

    public List<Reservation> getReservationList() {
        return reservationList;
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

    // returns a list of upcoming reservations
    public List<Reservation> upcomingReservations() {

        //create the list that will hold the upcoming reservations after the check

        List<Reservation> upcomingReservationsList = new ArrayList<>();

        Reservation checkUpcomingReservation; // used to check the if the reservation is upcoming or has already happened
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
    public List<Reservation> reservationsOfDay(LocalDate date) {

        List<Reservation> reservationDayList = new ArrayList<>();// creates list that will hold reservations of specific date
        Reservation checkReservation;   // used to  hold the days reservsation and then pass it in the list
        if (!reservationList.isEmpty()) {
            for (int i = 0; i < reservationList.size(); i++) {

                // ckecks if ths reservation in the list of reservations has a specific date in its timeslot

                if (reservationList.get(i).getTimeslot().getDateOfAppointment().equals(date)) {// ckecks if ths reservation in the list
                    checkReservation = reservationList.get(i);

                    reservationDayList.add(checkReservation);

                }
            }
        }
        return reservationDayList;
    }
}


/// updating reservation
   /* public Reservation updateReservation(long amka, Timeslot timeslot, Doctor doctor) {
        Insured insured1 = null;


        Reservation reservation = null;
        for (Insured insuredPerson : insuredList) {

            if (insuredPerson.getAmka() == amka) {
                reservation = createReservation(amka, timeslot, doctor);
               int counter= reservation.getReservationsChanges()++;
            }
            else{
                throw new IllegalStateException("There is no person insured with that amka");
            }
        }

        return reservation;
    }*/



