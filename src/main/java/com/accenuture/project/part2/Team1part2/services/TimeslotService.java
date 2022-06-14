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

    //Creates timeslots and puts them in list
    public List<Timeslot> createTimeslots(Timeslot timeslot) {

      /* int addtimeslotcode =  timeslot.getTimeslotCode();  //getting the timeslot code for each timeslot created

        addtimeslotcode=addtimeslotcode++;      //changing the timeslot code for each timeslot created +1 each time

       timeslot.setTimeslotCode(addtimeslotcode);// setting the timeslot code for each timeslot*/
       timeslots.add(timeslot);
       timeslot.reserve();

        return timeslots;
    }

    // CREATE LIST OF TIMESLOTS THAT HAVE BEEN CHOSEN BY CHECKING WITCH TIMESLOTS ARE IN LIST OF RESERVATIONS
    public List<Timeslot> createChosenTimeslotList(Timeslot timeslot) {

        if(reservationsService.getReservationList().contains(timeslot)){

            chosenTimeslots.add(timeslot);
        }


        return chosenTimeslots;
    }/////////////CHECK UPDATE HAVE TO DELETE DESMEYMENO


    //  elegxei ean to timeslot  einai keno i oxi
    public String  checkTimeslotAvailability(int day, int month, int year) {

        String results = null;
        for (Timeslot t : timeslots) {

            if (t.getDateOfAppointment().getDayOfMonth() == day && t.getDateOfAppointment().getMonthValue() == month &&
                    t.getDateOfAppointment().getYear() == year) { // chescks if it's in the list a timeslot that exists
                if (t.isReserved()) {
                    results="not null";
                    return "This timeslot is not free for use!";
                }
            }
        }
        if(results==null) {
            return "This timeslot is not free for use! Please chose another one";
        }

        return "";
    }


    public List<Timeslot> showAvailableTimeslots(int day, int month, int year) {

        //  if(timeslot day int year ) is available show it

        List<Timeslot> freeTimeslots = new ArrayList<>();

        for (Timeslot t : timeslots) {

            if (t.getDateOfAppointment().getDayOfMonth() == day && t.getDateOfAppointment().getMonthValue() == month &&
                    t.getDateOfAppointment().getYear() == year) { // chescks if it's in the list a timeslot that exists

                    if (!chosenTimeslots.contains(t)) {
                        freeTimeslots.add(t);
                    }
            }
        }
        return freeTimeslots;
    }
}
