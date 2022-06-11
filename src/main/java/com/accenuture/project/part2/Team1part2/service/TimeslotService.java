package com.accenuture.project.part2.Team1part2.service;

import com.accenuture.project.part2.Team1part2.modules.Timeslot;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService{


    List<Timeslot> timeslots = new ArrayList<>();

    // ADDS TIMESLOTS TO LIST//
    public void addTimeslotToList(Timeslot timeslot){


       // for(Timeslot t: timeslots){

             timeslots.add(timeslot);
       // }


    }

    // epistrefei to timeslot apo tin lista timeslots pou na exei tin imera,mina,xrono allisw keno
    public Timeslot getTimeslotByDate(int day, int month, int year) {

        for(Timeslot t:  timeslots){

            if(t.getDay()==day && t.getMonth()==month && t.getYear()==year){

                return t;
            }

            else{
                System.out.println("The timeslot you want is not available");
            }
        }

       return null;

    }


}
