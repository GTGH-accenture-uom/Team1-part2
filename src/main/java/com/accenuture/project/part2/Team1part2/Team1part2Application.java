package com.accenuture.project.part2.Team1part2;

import com.accenuture.project.part2.Team1part2.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Team1part2Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Team1part2Application.class, args);


		//CREATE 15 INSURED PEOPLE AND ADD THEM TO AN ARRAYLIST
		Insured i1 = new Insured(121212121L, 26029799999L, "Megan", "Fox", LocalDate.of(1950,1,1), "mf@gmail.com");
		Insured i2 = new Insured(123456789L, 12121212121L, "Tom", "Hardy", LocalDate.of(1951,2,2), "th@gmail.com");
		Insured i3 = new Insured(148274971L, 32546573698L, "Jason", "Statham", LocalDate.of(1952,3,3), "js@gmail.com");
		Insured i4 = new Insured(846108374L, 58347463746L, "Ismael", "Blanco", LocalDate.of(1953,4,4), "ib@gmail.com");
		Insured i5 = new Insured(234134253L, 53452345345L, "Nikos", "Nikou", LocalDate.of(1954,5,5), "nn@gmail.com");
		Insured i6 = new Insured(409876543L, 45634564566L, "Kyprios", "Kypriou", LocalDate.of(1955,6,6), "kk@gmail.com");
		Insured i7 = new Insured(876365213L, 13423645645L, "Alfa", "Vita", LocalDate.of(1956,7,7), "av@gmail.com");
		Insured i8 = new Insured(987987987L, 67356345345L, "Gal", "Gadot", LocalDate.of(1957,8,8), "ggwp@yahoo.com");
		Insured i9 = new Insured(123412345L, 74563124535L, "Kayaba", "Akihiko", LocalDate.of(1950,9,9), "ka@gmail.com");
		Insured i10 = new Insured(345672432L, 52435234535L, "Naruto", "Uzumaki", LocalDate.of(1951,10,10), "nu@yahoo.com");
		Insured i11 = new Insured(452856463L, 67453235434L, "Itachi", "Uchiha", LocalDate.of(1997,11,11), "iu@gmail.com");
		Insured i12 = new Insured(972039845L, 62453523452L, "Bob", "Mastoras", LocalDate.of(1998,12,12), "bm@yahoo.com");
		Insured i13 = new Insured(666655554L, 45243623454L, "Panos", "Katos", LocalDate.of(1999,1,13), "pk@gmail.com");
		Insured i14 = new Insured(129837465L, 63453154523L, "Rafael", "Nadal", LocalDate.of(1955,2,14), "rn@yahoo.com");
		Insured i15 = new Insured(965398721L, 51345234534L, "Gyros", "Apola", LocalDate.of(1956,3,15), "ga@gmail.com");

		List<Insured> insuredPeople= new ArrayList<>();
		insuredPeople.add(i1);
		insuredPeople.add(i2);
		insuredPeople.add(i3);
		insuredPeople.add(i4);
		insuredPeople.add(i5);
		insuredPeople.add(i6);
		insuredPeople.add(i7);
		insuredPeople.add(i8);
		insuredPeople.add(i9);
		insuredPeople.add(i10);
		insuredPeople.add(i11);
		insuredPeople.add(i12);
		insuredPeople.add(i13);
		insuredPeople.add(i14);
		insuredPeople.add(i15);

		//CREATE 4 DOCTORS AND ADD THEM TO AN ARRAYLIST
		Doctor doc1 = new Doctor(17453283745L,"Dr.Markos","Seferlis");
		Doctor doc2 = new Doctor(25623432411L,"Dr.Anna","Korakaki");
		Doctor doc3 = new Doctor(33452341563L,"Dr.Katia","Tarabanko");
		Doctor doc4 = new Doctor(42345264243L,"Dr.Periklis","Negrepontis");

		List<Doctor> doctors = new ArrayList<>();
		doctors.add(doc1);
		doctors.add(doc2);
		doctors.add(doc3);
		doctors.add(doc4);

		//CREATE AND FILL 2 TIMESLOTS, ONE FOR EACH VACC.CENTER
		List<Timeslot> timeslots1 = new ArrayList<>();
		List<Timeslot> timeslots2 = new ArrayList<>();

		for(int d=20; d<22; d++){

			int slotsPerDay = 5;
			Doctor tempd1, tempd2;

			if (d==20){ tempd1 = doc1; tempd2 = doc2; }
			else{ tempd1 = doc3; tempd2 = doc4; }

			for(int h=18; h<23; h++){

				if(slotsPerDay==0) break;

				for(int mins=0; mins<60; mins+=20){
					Timeslot t1 = new Timeslot(LocalDate.of(2022, 6, d), LocalTime.of(h, mins), mins, mins+19, tempd1);
					Timeslot t2 = new Timeslot(LocalDate.of(2022, 6, d), LocalTime.of(h, mins), mins, mins+19, tempd2);
					timeslots1.add(t1);
					timeslots2.add(t2);
					slotsPerDay--;
					if(slotsPerDay==0) break;
				}
			}
		}

		//CREATE 2 VACC.CENTERS AND ADD THEM TO AN ARRAYLIST
		VaccinationCenter ippokratio = new VaccinationCenter("Ippokrateio GNTH", "Egnatias 223", timeslots1);
		VaccinationCenter axepa = new VaccinationCenter("AXEPA PN", "Kiriakidi 1", timeslots2);

		List<VaccinationCenter> vaccinationCenters = new ArrayList<VaccinationCenter>();
		vaccinationCenters.add(ippokratio);
		vaccinationCenters.add(axepa);

		//CREATE 8 RESERVATIONS AND ADD THEM TO AN ARRAYLIST
		Reservation reservation1 = new Reservation(i1, i1.chooseVaccinationCenter(vaccinationCenters));
		Reservation reservation2 = new Reservation(i2, i2.chooseVaccinationCenter(vaccinationCenters));
		Reservation reservation3 = new Reservation(i3, i3.chooseVaccinationCenter(vaccinationCenters));
		Reservation reservation4 = new Reservation(i4, i4.chooseVaccinationCenter(vaccinationCenters));
		Reservation reservation5 = new Reservation(i5, i5.chooseVaccinationCenter(vaccinationCenters));
		Reservation reservation6 = new Reservation(i6, i6.chooseVaccinationCenter(vaccinationCenters));
		Reservation reservation7 = new Reservation(i7, i7.chooseVaccinationCenter(vaccinationCenters));
		Reservation reservation8 = new Reservation(i8, i8.chooseVaccinationCenter(vaccinationCenters));

		List<Reservation> reservations = new ArrayList<>();
		reservations.add(reservation1);
		reservations.add(reservation2);
		reservations.add(reservation3);
		reservations.add(reservation4);
		reservations.add(reservation5);
		reservations.add(reservation6);
		reservations.add(reservation7);
		reservations.add(reservation8);

		//CREATE 6 VACCINATIONS AND ADD THEM TO AN ARRAYLIST
		Vaccination vac1 = reservation1.getTimeslot().getDoctor().vaccinate(reservation1.getInsured(),
				reservation1.getTimeslot().getDoctor(),
				reservation1.getTimeslot().getDateOfAppointment(),
				reservation1.getTimeslot().getDateOfAppointment().plusMonths(6));
		Vaccination vac2 = reservation2.getTimeslot().getDoctor().vaccinate(reservation2.getInsured(),
				reservation2.getTimeslot().getDoctor(),
				reservation2.getTimeslot().getDateOfAppointment(),
				reservation2.getTimeslot().getDateOfAppointment().plusMonths(6));
		Vaccination vac3 = reservation3.getTimeslot().getDoctor().vaccinate(reservation3.getInsured(),
				reservation3.getTimeslot().getDoctor(),
				reservation3.getTimeslot().getDateOfAppointment(),
				reservation3.getTimeslot().getDateOfAppointment().plusMonths(6));
		Vaccination vac4 = reservation4.getTimeslot().getDoctor().vaccinate(reservation4.getInsured(),
				reservation4.getTimeslot().getDoctor(),
				reservation4.getTimeslot().getDateOfAppointment(),
				reservation4.getTimeslot().getDateOfAppointment().plusMonths(6));
		Vaccination vac5 = reservation5.getTimeslot().getDoctor().vaccinate(reservation5.getInsured(),
				reservation5.getTimeslot().getDoctor(),
				reservation5.getTimeslot().getDateOfAppointment(),
				reservation5.getTimeslot().getDateOfAppointment().plusMonths(6));
		Vaccination vac6 = reservation6.getTimeslot().getDoctor().vaccinate(reservation6.getInsured(),
				reservation6.getTimeslot().getDoctor(),
				reservation6.getTimeslot().getDateOfAppointment(),
				reservation6.getTimeslot().getDateOfAppointment().plusMonths(6));

		List<Vaccination> vaccinations = new ArrayList<>();
		vaccinations.add(vac1);
		vaccinations.add(vac2);
		vaccinations.add(vac3);
		vaccinations.add(vac4);
		vaccinations.add(vac5);
		vaccinations.add(vac6);


//----------------------------------------------------------------------------------------------------------------------
//------------------------------------------output testings-------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

		FileWriter writer = new FileWriter("C:/Users/George/Desktop/output_results.txt");

		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println("Τα επικείμενα ραντεβού για κάθε εμβολιαστικό κέντρο είναι: \n\n");
		doc1.checkReservations(vaccinationCenters);

		writer.write(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .\n");
		writer.write("Τα επικείμενα ραντεβού για κάθε εμβολιαστικό κέντρο είναι: \n\n");
		writer.write(doc1.writeToFileReservations(vaccinationCenters));

		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println("Οι ελεύθερες χρονικές θυρίδες κάθε εμβολιαστικού κέντρου είναι: \n\n");

		writer.write("\n. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .\n");
		writer.write("Οι ελεύθερες χρονικές θυρίδες κάθε εμβολιαστικού κέντρου είναι: \n\n");

		for(VaccinationCenter vc : vaccinationCenters)
		{
			String results = "";
			int id = 1;

			for (Timeslot t : vc.getTimeslots())
			{
				if (!t.isReserved()) {
					results += "\n" + id++ + ". " + t.toString();
				}
			}
			results += "\n";
			System.out.println("VaccinationCenter[ " + "Code: " + vc.getCode() + ", Address: " + vc.getAddress() + " ]" + results );
			System.out.println();
			writer.write("VaccinationCenter[ " + "Code: " + vc.getCode() + ", Address: " + vc.getAddress() + " ]" + results );
			writer.write("\n");
		}

		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println("Οι εμβολιασμοί (ημερομηνία εμβολιασμού και ονοματεπώνυμο ασφαλισμένου) που " +
				"πραγματοποίησε κάθε γιατρός, για όλους τους γιατρούς, είναι: \n\n");

		writer.write("\n. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .\n");
		writer.write("Οι εμβολιασμοί (ημερομηνία εμβολιασμού και ονοματεπώνυμο ασφαλισμένου) που " +
				"πραγματοποίησε κάθε γιατρός, για όλους τους γιατρούς, είναι: \n\n");

		for (Doctor d : doctors)
		{
			String results = "";
			int id = 1;

			for(Vaccination v : vaccinations)
			{
				if(v.getDoctor()==d){
					results += "\n" + id++ + ". " + "Date: "+v.getVaccinationDate()+", Insured: "+v.getInsured().getName()+" "+v.getInsured().getSurname();
				}
			}
			results += "\n";
			System.out.println(d+results);
			System.out.println();
			writer.write(d+results);
			writer.write("\n");
		}

		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println("Οι ασφαλισμένοι άνω των 60 ετών που δεν έχουν κλείσει ραντεβού για εμβολιασμό είναι οι: \n");

		writer.write("\n. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .\n");
		writer.write("Οι ασφαλισμένοι άνω των 60 ετών που δεν έχουν κλείσει ραντεβού για εμβολιασμό είναι οι: \n\n");

		for(Insured ins : insuredPeople)
		{
			int index = 0;
			boolean found = false;

			for(Reservation r : reservations) {
				index++;
				if ( ins == r.getInsured() ) {
					found = true;
					break;
				}
			}

			if(!found & ( LocalDate.now().getYear() - (ins.getBirthdate().getYear()) )>60 )
			{
				System.out.println(ins);
				writer.write(ins.toString());
				writer.write("\n");
			}
		}

		writer.close();

	}


}
