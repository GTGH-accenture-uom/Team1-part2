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

       timeslots.add(timeslot);

        return chosenTimeslots;
    }

    // CREATE LIST OF TIMESLOTS THAT HAVE BEEN CHOSEN BY CHECKING WITCH TIMESLOTS ARE IN LIST OF RESERVATIONS
    public List<Timeslot> createChosenTimeslotList(Timeslot timeslot) {

        if(reservationsService.getReservationList().contains(timeslot)){

            chosenTimeslots.add(timeslot);
        }


        return chosenTimeslots;
    }


    //  elegxei ean to timeslot  einai keno i oxi
    public String getTimeslotByDate(int day, int month, int year) {

        for(Timeslot t:  timeslots){

            if(t.getDateOfAppointment().getDayOfMonth()==day && t.getDateOfAppointment().getMonthValue()==month &&
                    t.getDateOfAppointment().getYear()==year){ // chescks if it's in the list a timeslot that exists
                for(Timeslot t1: chosenTimeslots){
                    if(t1.getDateOfAppointment().getDayOfMonth()!=day && t1.getDateOfAppointment().getMonthValue()!=month &&
                            t1.getDateOfAppointment().getYear()!=year){// checks that it is not an already chosen timeslot
                        //chosenTimeslots.add(t); //  puts the
                        return "This timeslot is free for use!";

                    }
                }
            }
            else{
               // throw new RuntimeException("That timeslot doesn't exist");
                throw new IllegalStateException("That timeslot doesn't exist");
            }
        }
        return "This timeslot is not free for use! Please chose another one";
    }


}
