package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class Visualisation extends ActionForPerson {

    protected final static String COMMAND = "visualisation";

    /*
    * TODO
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        Patient patient = PatientFactory.current().patientNamed(name);
        if (patient == null) {
            System.out.println("Aucun patient de ce nom.");
        } else {
           patient.printStayingCard();
        }
    }

    @Override
    public void description() {
        System.out.println("Permet de visualiser un séjour en cours.");
    }
}
