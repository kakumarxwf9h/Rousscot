package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by aurelien on 02/11/2015.
 */
public class NextConsultation extends ActionForPerson {
    protected final static String COMMAND = "prochaineconsultation";

    @Override
    public void action(BufferedReader br, String name) throws IOException {
        Patient patient = PatientFactory.current().patientNamed(name);
        if (patient == null) {
            System.out.println("Aucun patient de ce nom.");
        } else if (!patient.isAtTheHospital()) {
            System.out.println("Le patient n'est pas à l'hopital.");
        } else {
            patient.printNextConsultation();
        }

    }

    @Override
    public String description() {
        return "Permet de connaître la prochaine consultation d'un patient.";
    }
}
