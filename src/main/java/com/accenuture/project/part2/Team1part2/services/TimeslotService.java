package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService{

    @Autowired
    ReservationsService reservationsService;

    List<Timeslot> timeslots = new ArrayList<>();
    List<Timeslot> chosenTimeslots = new ArrayList<>();

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    //creates timeslots and puts them in list
    public List<Timeslot> createTimeslots(Timeslot timeslot) {

       timeslots.add(timeslot);
       timeslot.reserve();

       return timeslots;
    }

    //return reserved timeslots with reservation's help
    public List<Timeslot> createChosenTimeslotList(Timeslot timeslot) {

        if(reservationsService.getReservationList().contains(timeslot)){
            chosenTimeslots.add(timeslot);
        }

        return chosenTimeslots;
    }/////////////CHECK UPDATE HAVE TO DELETE DESMEYMENO


    //given (int day, int month, int year), checks if timeslot is reserved
    public String checkTimeslotAvailability(int day, int month, int year) {

        for (Timeslot t : timeslots) {

            if (t.getDateOfAppointment().getDayOfMonth() == day & t.getDateOfAppointment().getMonthValue() == month &
                    t.getDateOfAppointment().getYear() == year) { // chescks if it's in the list a timeslot that exists
                if (t.isReserved()) {
                    return "This timeslot is not free to use! Please chose another one!";
                }
            }
        }

        return "This timeslot is free to use!";

    }

    //given (int day, int month, int year), return all unreserved
    public List<Timeslot> showAvailableTimeslots(int day, int month, int year) {

        List<Timeslot> freeTimeslots = new ArrayList<>();

        for (Timeslot t : timeslots) {

            if (t.getDateOfAppointment().getDayOfMonth() == day & t.getDateOfAppointment().getMonthValue() == month &
                    t.getDateOfAppointment().getYear() == year) { // checks if it's in the list a timeslot that exists

                if (!chosenTimeslots.contains(t)) {
                    freeTimeslots.add(t);
                }
            }
        }
        return freeTimeslots;
    }
}
