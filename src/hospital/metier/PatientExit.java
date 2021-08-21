package hospital.metier;

import hospital.domaine.Patient;
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
        Patient patient = PatientFactory.current().patientNamed(name);
        if (patient == null) {
            System.out.println("Aucun patient de ce nom.");
        } else {
            //TODO verifer qu'il y ai pas de consultation restante sinon warning.
            patient.destroyStayingCard();
            System.out.println("Carte de sï¿½jour de " + patient.lastName() + " dï¿½truite.\n");
        }

    }

    @Override
    public void description() {
        System.out.println("Permet la sortie d'un patient.");
    }
}
