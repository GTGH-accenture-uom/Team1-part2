package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.accenuture.project.part2.Team1part2.Team1part2Application.insuredList;
import static com.accenuture.project.part2.Team1part2.Team1part2Application.reservations;

@Service
public class ReservationsService {

    //make a reservation
    public String createReservation(TimeslotInsured timeslotInsured) {

        //if insured person given exists
        if (insuredList.contains(timeslotInsured.getInsured()) & !timeslotInsured.getTimeslot().isReserved()) {

            Reservation res = new Reservation(timeslotInsured.getInsured(), timeslotInsured.getTimeslot());
            reservations.add(res);

            timeslotInsured.getTimeslot().reserve(); //reserve timeslot chosen

            return "Reservation created successfully!!!";
        } else {
            if (!insuredList.contains(timeslotInsured.getInsured())) {   //if insured was not found
                return "Didn't find insured!!!";
            } else if (timeslotInsured.getTimeslot().isReserved()) {   //if timeslot is reserved
                return "Timeslot is reserved!!!";
            } else {
                return "!!!!!!!!!ERROR!!!!!!!!!!!!!!";   //all other cases
            }
        }

    }

    //returns all reservations
    public List<Reservation> getReservationList() {
        return reservations;
    }

    // returns upcoming reservations
    public List<Reservation> upcomingReservations() {

        //create the list that will hold the upcoming reservations after the check
        List<Reservation> upcomingReservationsList = new ArrayList<>();

        Reservation checkUpcomingReservation = null; // used to check if the reservation is upcoming or has already happened

        if (!reservations.isEmpty()) {
            for (int i = 0; i < reservations.size(); i++) {

                checkUpcomingReservation = reservations.get(i);

                // if date of reservation is after todays date (=> upcoming), then add to list of upcoming reservations
                if (checkUpcomingReservation.getTimeslot().getDateOfAppointment().isAfter(LocalDate.now())) {
                    upcomingReservationsList.add(checkUpcomingReservation);
                }
            }
        }

        return upcomingReservationsList;
    }

    // returns a list of reservations at specific date
    public List<Reservation> reservationsOfDay(int day, int month, int year) {

        //creates list that will hold reservations at specific date
        List<Reservation> reservationDayList = new ArrayList<>();

        Reservation checkReservation = null;   //used to  hold the days reservsation and then pass it in the list

        if (!reservations.isEmpty()) {

            for (int i = 0; i < reservations.size(); i++) {

                // ckecks if the reservation in the list of reservations has a specific date in its timeslot

                if (reservations.get(i).getTimeslot().getDateOfAppointment().getDayOfMonth() == day &&
                        reservations.get(i).getTimeslot().getDateOfAppointment().getMonthValue() == month &&
                        reservations.get(i).getTimeslot().getDateOfAppointment().getYear() == year) {// ckecks if ths reservation in the list
                    checkReservation = reservations.get(i);

                    reservationDayList.add(checkReservation);

                }
            }
        }
        return reservationDayList;
    }

    //update reservation
    public String updateReservation(Reservation reservation, TimeslotInsured timeslotInsured) {

        Reservation res = null;

        if (reservations.contains(reservation.getInsured()) & reservation.getReservationsChanges() < 2) {

            reservation.increaseReservationsChanges();
            reservations.remove(reservation);

            //NEED reservationTimeslotInsured Class in ReservationsController
            res = createReservation(reservationTimeslotInsured.get(timeslotInsured));

            return "Reservation updated successfully!";

        } else {
            if (!reservations.contains(reservation.getInsured())) {
                return "Reservation given does not exist!";
            } else if (reservation.getReservationsChanges() >= 2) {
                return "You have already changed your appointment twice!";
            } else {
                return "!!!!!!ERROR!!!!!!";
            }
        }
    }


}



















//
//        for (Insured insuredPerson : insuredList) {
//
//            if (reservation.getReservationsChanges() < 2) {
//
//                if (reservations.contains(reservation.getInsured())) { // ama iparxei idi klesimeno rantevou me idio insuured
//
//                    reservations.remove(reservation); //// prin dilwnei kainourio  reservation diagrafei ton proigoume
//                    res = createReservation(reservation.getInsured().getAmka(), timeslot, doctor);
//
//
//                    if (res != null) {   // efoson ginei o emboliasmos  tote na auksithei o counter alliws oxi se periptwsi sfalmatoa
//                        counter++;
//                        reservation.setReservationsChanges(counter);// wste na enimerwnetai gia kathe insured poses allages ekane
//                        return "Reservation updated!";
//                    } else {
//                        throw new RuntimeException();
//                    }
//                }
//            }
//            else
//            { return "You have already changed your appointment twice"; }
//
//        }
//        return " ";
//    }
//}
//
//
//


    /// updating reservation
//    public Reservation updateReservation(ReservationTimeslot reservationTimeslot) {
//        Insured insured1 = null;
//
//        Reservation reservation1;
//
//        for (Insured insuredPerson : insuredList) {
//
//            if (insuredPerson.getAmka() == reservationTimeslot.getReservation().getInsured().getAmka()) {
//                reservation1 = createReservation(new TimeslotInsured(reservationTimeslot.getReservation().getInsured()),reservationTimeslot.getReservation().getTimeslot())
//               int counter= reservation.getReservationsChanges()++;
//            }
//            else{
//                throw new IllegalStateException("There is no person insured with that amka");
//            }
//        }
//
//        return reservation;
//    }




