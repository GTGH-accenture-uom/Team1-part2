package com.accenuture.project.part2.Team1part2.services;

import com.accenuture.project.part2.Team1part2.models.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.accenuture.project.part2.Team1part2.Team1part2Application.timeslots1;


@Service
public class TimeslotService{

    @Autowired
    ReservationsService reservationsService;

    List<Timeslot> timeslots = timeslots1;
    List<Timeslot> chosenTimeslots = new ArrayList<>();

    public List<Timeslot> getTimeslots() {
        return timeslots;

    }


    //given (int day, int month, int year), return all unreserved
    public List<Timeslot> showAvailableTimeslots(int day, int month, int year) {

        List<Timeslot> freeTimeslots = new ArrayList<>();

        for (Timeslot t : timeslots) {

            if (t.getDateOfAppointment().getDayOfMonth() == day & t.getDateOfAppointment().getMonthValue() == month &
                    t.getDateOfAppointment().getYear() == year) { // checks if it's in the list a timeslot that exists

                if (!t.isReserved()) {
                    freeTimeslots.add(t);
                }
            }
        }
        return freeTimeslots;
    }
}
