package com.accenuture.project.part2.Team1part2.models;

public class Reservation {

    private Insured insured;
    private Timeslot timeslot;

//    private class Set
//    {
//        Insured val1;
//        Timeslot val2;
//
//        private Set(Insured val1, Timeslot val2) {
//            this.val1 = val1;
//            this.val2 = val2;
//        }
//    }
//
//    public static List<Set> allReservations = new ArrayList<Set>();

    public Reservation(Insured insured, Timeslot timeslot) {

        this.insured = insured;
        this.timeslot = timeslot;

//        Set s = new Set(insured, timeslot);
//        allReservations.add(s);
    }

    //getters
    public Insured getInsured() {return insured;}

    public Timeslot getTimeslot() {return timeslot;}

//    public static List<Set> getAllReservations() {
//        return allReservations;
//    }

    //setters
//    public void setInsured(Insured insured) {this.insured = insured;}
//
//    public void setTimeslot(Timeslot timeslot) {this.timeslot = timeslot;}

    @Override
    public String toString() {
        return "Reservation[ " +
                "Insured: " + insured +
                ", Timeslot: " + timeslot +
                " ]";
    }

}
