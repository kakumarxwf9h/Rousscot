package hospital.metier;

import hospital.domaine.Patient;
import hospital.domaine.Specialist;
import hospital.domaine.Speciality;
import hospital.factory.PatientFactory;
import hospital.factory.ReportFactory;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class Consultation extends ActionForPerson {

    protected final static String COMMAND = "consultation";

    /*
    * TODO
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        Specialist specialist = SpecialistFactory.current().specialistNamed(name);
        if (specialist == null) {
            System.out.println("Aucun spécialiste de ce nom.");
        } else {
            this.consultWith(specialist, br);
        }
    }

    /*
    * TODO
     */
    public void consultWith(Specialist specialist, BufferedReader br) throws IOException {
        System.out.println("Nom du patient: ");
        Patient patient = PatientFactory.current().patientNamed(br.readLine());
        Speciality speciality = specialist.getSpeciality();
        if (patient == null) {
            System.out.println("Aucun patient de ce nom.");
        } else if (patient.getStayCard() == null) {
            System.out.println("Le patient n'est pas à l'hopital");
        } else if (!(patient.needSpeciality(speciality))) {
            System.out.println("Le patient existe mais n'a pas besoin de cette spécialité.");
        } else {
            patient.printTrackingCardOf(speciality);
            this.createNewReport(patient, specialist, br);
        }
    }

    /*
    * TODO
     */
    public void createNewReport(Patient patient, Specialist specialist, BufferedReader br) throws IOException {
        System.out.println("Rapport: ");
        // todo gné ? j'ai un peu du mal à voir comment ça va s'imbriquer
        ReportFactory.current().createReport(patient, specialist, br.readLine());
    }

    @Override
    public void description() {
        System.out.println("Permet d'effectuer une consultation.");
    }
}
