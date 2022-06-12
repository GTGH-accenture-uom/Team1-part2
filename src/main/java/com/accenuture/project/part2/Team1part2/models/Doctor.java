package com.accenuture.project.part2.Team1part2.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private long amka;
    private String name;
    private String surname;

    public Doctor(long amka, String doctor_name, String doctor_surname) {
        this.amka = amka;
        this.name = doctor_name;
        this.surname = doctor_surname;
    }

    //getters
    public long getAmka() {return amka;}

    public String getName() {return name;}

    public String getSurname() {return surname;}

    //setters
//    public void setAmka(long amka) {this.amka = amka;}
//
//    public void setName(String name) {this.name = name;}
//
//    public void setSurname(String surname) {this.surname = surname;}

    public Vaccination vaccinate(Insured insured, Doctor doctor, LocalDate vaccinationDate, LocalDate expirationDate){
        Vaccination vac = new Vaccination(insured, doctor, vaccinationDate, expirationDate);
        return vac;
    }

    public String writeToFileReservations(List<VaccinationCenter> vaccinationCenters){

        String text ="";
        for(VaccinationCenter vc : vaccinationCenters)
        {
            String results = "";
            int id = 1;

            for (Timeslot t : vc.getTimeslots())
            {
                if (t.isReserved()) {
                    results += "\n" + id++ + ". " + t.toString();
                }
            }
            text += "VaccinationCenter[ " + "Code: " + vc.getCode() + ", Address: " + vc.getAddress() + " ]" + results + "\n\n";
        }
        return text;
    }

    public void checkReservations(List<VaccinationCenter> vaccinationCenters){

        for(VaccinationCenter vc : vaccinationCenters)
        {
            String results = "";
            int id = 1;

            for (Timeslot t : vc.getTimeslots())
            {
                if (t.isReserved()) {
                    results += "\n" + id++ + ". " + t.toString();
                }
            }
            System.out.println("VaccinationCenter[ " + "Code: " + vc.getCode() + ", Address: " + vc.getAddress() + " ]" + results + "\n\n");
        }

    }

    public List<Reservation> checkReservations(List<VaccinationCenter> vaccinationCenters, List<Reservation> reservationList){

        List<Reservation> tmp = new ArrayList<>();

        for(VaccinationCenter vc : vaccinationCenters)
        {
            String results = "";
            int id = 1;

            for (Timeslot t : vc.getTimeslots())
            {
                for (Reservation r : reservationList) {
                    if (t.isReserved() & t==r.getTimeslot()) {
                        results += "\n" + id++ + ". " + t.toString();
                        tmp.add(r);
                    }
                }
            }
            System.out.println("VaccinationCenter[ " + "Code: " + vc.getCode() + ", Address: " + vc.getAddress() + " ]" + results + "\n");
        }
        return tmp;
    }

    @Override
    public String toString() {
        return  "Doctor[ " +
                "First_name:" + name +
                ", Last_name:" + surname +
                ", AMKA:" + amka +
                " ]";
    }
}
