package com.accenuture.project.part2.Team1part2.models;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Insured {

    private long afm;
    private long amka;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String email;

    //constructors
    public Insured(long afm, long amka, String name, String surname, LocalDate birthdate, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.surname= surname;
        this.birthdate = birthdate;
        this.email = email;
    }

    public Boolean checkVaccinationStatus(List<Vaccination> vaccinations){
        for(Vaccination v : vaccinations) {
            if (v.getInsured().getAfm()==this.afm & v.getExpirationDate().isAfter(LocalDate.now()))
            {
                System.out.println("You have vaccine coverage!");
                return true;
            }
        }
        System.out.println("You don't have vaccine coverage!");
        return false;
    }

    public Timeslot chooseVaccinationCenter(List<VaccinationCenter> VaccinationCenters){

        int vid=0;
        Scanner scan = new Scanner(System.in);

        for (VaccinationCenter vc : VaccinationCenters)
        {
            System.out.println(++vid +") " + vc);
        }

        System.out.print("Choose a Vaccination Center please: ");
        vid = scan.nextInt();

        VaccinationCenter temp = null;
        try{
            temp =  VaccinationCenters.get(vid-1);
        }
        catch (Exception e){
            System.out.println("This Vaccination Center does not exists!");
            return null;
        }

        Timeslot timeslotChosen = chooseTimeslot(temp, vid);

        return timeslotChosen;
    }

    private Timeslot chooseTimeslot(VaccinationCenter vaccinationCenter, int vid) {

        int tid = 0;
        Scanner scan = new Scanner(System.in);

        for (Timeslot t : vaccinationCenter.timeslots) {
            if (!t.isReserved()) {
                System.out.println(++tid + ". " + t);
            }
            else
            {
                System.out.println(++tid + ". " + "- - - Reserved - - -");
            }
        }

        System.out.print("Choose a timeslot please: ");

        tid = scan.nextInt();
        Timeslot temp = null;

        try{
            if(vaccinationCenter.getTimeslots().get(tid-1).isReserved())
            {
                System.out.println("This timeslot is already reserved!");
                return null;
            }
            temp =  vaccinationCenter.getTimeslots().get(tid-1);
            vaccinationCenter.timeslots.get(tid-1).reserve();
        }
        catch (Exception e){
            System.out.println("This Timeslot does not exists");
            return null;
        }

        System.out.println("You chose timeslot: "+temp);

        return temp;
    }

    public Timeslot editTimeslot( List<Reservation> reservations, List<VaccinationCenter> vaccinationCenters){
        Timeslot t = null;
        for(Reservation r : reservations){
            if(r.getInsured().getAfm()==this.afm)
            {
                t = chooseVaccinationCenter(vaccinationCenters);
                r.getTimeslot().unReserve();
                return t;
            }
        }
        System.out.println("You don't have any reservation yet!");
        return null;
    }

    //setters
//    public void setAfm(long afm) {
//        this.afm = afm;
//    }
//
//    public void setAmka(long amka) {
//        this.amka = amka;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public void setBirthdate(LocalDate birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    //getters
    public long getAfm() {
        return afm;
    }

    public long getAmka() {
        return amka;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "Insured[ " +
                "AFM:" + afm +
                ", AMKA:" + amka +
                ", First_name: " + name +
                ", Last_name: " + surname +
                ", Birthdate: " + birthdate +
                ", email:" + email +
                " ]";
    }

}
