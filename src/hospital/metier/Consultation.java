package hospital.metier;

import hospital.domaine.Patient;
import hospital.domaine.Specialist;
import hospital.exception.IllegalReportException;
import hospital.exception.PatientNotFoundException;
import hospital.exception.SpecialistNotFoundException;
import hospital.factory.PatientFactory;
import hospital.factory.ReportFactory;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am a class that manage a consultation.
 *
 * @author Cyril Ferlicot & Aur�lien Rousseau
 */
public class Consultation extends ActionForPerson {

    protected final static String COMMAND = "consultation";

    /**
     * I manage a consultation.
     *
     * @param br   a BufferedReader if the action need to interact with the user.
     * @param name The name of the person
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        try {
            Specialist specialist = SpecialistFactory.current().specialistNamed(name);
            this.consultWith(specialist, br);
        } catch (SpecialistNotFoundException e) {
            System.out.println("Aucun sp�cialiste de ce nom : " + e.name() + ".\n");
        }
    }

    /**
     * TODO
     *
     * @param specialist
     * @param br
     * @throws IOException
     */
    public void consultWith(Specialist specialist, BufferedReader br) throws IOException {
        System.out.println("Nom du patient: ");
        try {
            Patient patient = PatientFactory.current().patientNamed(br.readLine());
            this.makeConsultation(patient, specialist, br);
        } catch (PatientNotFoundException e) {

            System.out.println("Aucun patient de ce nom : " + e.name() + ".\n");
        }
    }

    public void makeConsultation(Patient patient, Specialist specialist, BufferedReader br) throws IOException {
        if (patient.isAtTheHospital()) {
            System.out.println("Le patient n'est pas � l'hopital");
        } else {
            patient.printTrackingCardOf(specialist.getSpeciality());
            this.createNewReport(patient, specialist, br);
            System.out.println("Consultation finie. Compte rendu enregistr�.\n");
        }
    }

    /**
     * I create a new report for a patient and a specialist.
     *
     * @param patient    the patient.
     * @param specialist the specialist that write the report.
     * @param br         a BufferedReader.
     * @throws IOException
     */
    public void createNewReport(Patient patient, Specialist specialist, BufferedReader br) throws IOException {
        System.out.println("Rapport: ");
        try {
            ReportFactory.current().createReport(patient, specialist, br.readLine());
        } catch (IllegalReportException e) {
            if (e.alreadyConsulted()) {

                System.out.println("Le patient existe mais � d�j� consult�.\n");
            } else {

                System.out.println("Le patient existe mais n'a pas besoin de cette sp�cialit�. \n");
            }
        }
    }

    @Override
    public String description() {
        return "Permet d'effectuer une consultation.";
    }
}
