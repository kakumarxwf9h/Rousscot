package hospital.metier;

import hospital.domaine.Patient;
import hospital.exception.PatientNotFoundException;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am a class that manage the visualisation of a patient visit to the hospital.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class Visualisation extends ActionForPerson {

    protected final static String COMMAND = "visualisation";

    @Override
    public void action(BufferedReader br, String name) throws IOException {
        try {
            Patient patient = PatientFactory.current().patientNamed(name);
            patient.visualizeCards();
            System.out.println();
        } catch (PatientNotFoundException e) {
            System.out.println("Aucun patient de ce nom: " + e.name() + ".\n");
        }
    }

    @Override
    public String description() {
        return "Permet de visualiser un séjour en cours.";
    }
}
