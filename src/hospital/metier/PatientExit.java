package hospital.metier;

import hospital.domaine.Patient;
import hospital.exception.PatientNotAtHospitalException;
import hospital.exception.PatientNotFoundException;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am a class that manage a Patient exit.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class PatientExit extends ActionForPerson {

    protected final static String COMMAND = "sortie";

    /**
     * I manage a patient exit.
     *
     * @param br   a BufferedReader if the action need to interact with the user.
     * @param name The name of the person
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        try {
            Patient patient = PatientFactory.current().patientNamed(name);
            this.patientExit(patient, br);
        } catch (PatientNotFoundException e) {
            System.out.println("Aucun patient de ce nom: " + e.name() + ".\n");
        }

    }

    private void patientExit(Patient patient, BufferedReader br) throws IOException {
        try {
            if (!patient.stillNeedConsultation() || this.forceExit(br)) {
                patient.destroyStayingCard();
                System.out.println("Carte de sï¿½jour de " + patient.lastName() + " dï¿½truite.\n");
            }
        } catch (PatientNotAtHospitalException e) {
            System.out.println("Le patient " + e.name() + " n'est pas à l'hôpital.\n");
        }
    }

    private boolean forceExit(BufferedReader br) throws IOException {
        System.out.println("Ce patient à toujours besoin de consultation. Sortir de toute manière ? (O/N)");
        String command = br.readLine().toLowerCase();
        return command.equals("o") || command.equals("oui");
    }

    @Override
    public String description() {
        return "Permet la sortie d'un patient.";
    }
}
