package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class PatientExit extends ActionForPerson {

    protected final static String COMMAND = "sortie";

    /*
     * TODO
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        Patient patient = PatientFactory.current().patientNamed(name);
        if (patient == null) {
            System.out.println("Aucun patient de ce nom.");
        } else {
            //TODO verifer qu'il y ai pas de consultation restante sinon warning.
            patient.destroyStayingCard();
            System.out.println("Carte de s�jour de " + patient.lastName() + " d�truite.\n");
        }

    }

    @Override
    public void description() {
        System.out.println("Permet la sortie d'un patient.");
    }
}
