package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class PatientExit extends Action {

    protected final static String COMMAND = "exit";

    /*
     * TODO
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Nom du patient: ");
        Patient patient = PatientFactory.current().patientNamed(br.readLine());
        if (patient == null) {
            System.out.println("Aucun patient de ce nom.");
        } else {
            patient.destroyStayingCard();
            System.out.println("Carte de séjour de " + patient.lastName() + " détruite.");
        }

    }

    @Override
    public void description() {
        System.out.println("Permet la sortie d'un patient.");
    }
}
