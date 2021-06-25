package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am an action that manage the entrance of a Patient.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class Entrance extends Action {

    protected final static String COMMAND = "entrance";

    /*
    *   I register a Patient. If the patient is not on the base I call RegisterPatient.
    *
    *   @param br a BufferedReader if the action need to interact with the user.
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.print("Nom du patient: ");
        String name = br.readLine();
        Patient patient = getPatientNamed(name, br);
        this.createStayCardFor(patient);
    }

    /*
    *   I create a StayCard for a patient.
    *   @param patient the patient that needs the stay card.
     */
    public void createStayCardFor(Patient patient) {
        //TODO
    }

    /*
    *   I get a Patient from his name. If there is no patient I allow the user to register him.
    *   @param patient the patient name.
    *   @return an object Patient
     */
    public Patient getPatientNamed(String name, BufferedReader br) throws IOException {
        Patient patient = PatientFactory.current().patientNamed(name);
        if (patient == null) {
            (new RegisterPatient()).action(br);
            patient = PatientFactory.current().patientNamed(name);
        }
        return patient;
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer l'entrée d'un patient.");
    }
}
