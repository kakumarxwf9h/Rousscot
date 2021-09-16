package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am an action that register a Patient in the Hospital database.
 *
 * @author Cyril Ferlicot & Aur�lien Rousseau
 */
public class RegisterPatient extends ActionForPerson {

    protected final static String COMMAND = "enregistrer";

    /**
     * I am a method that communicate with the user to create a new patient.
     *
     * @param br   a Buffered reader to communicate with the user.
     * @param name the name of the patient to create.
     * @throws IOException in the case the user interaction goes wrong.
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        System.out.println("Num�ro de S�curit� Social: ");
        Long ss = Long.parseLong(br.readLine());
        System.out.println("Adresse: ");
        String address = br.readLine();
        System.out.println("Age: ");
        Integer age = Integer.parseInt(br.readLine());
        Patient patient = PatientFactory.current().createPatient(name, ss, address, age);
        System.out.println("Patient nommé " + patient.lastName() + " créé.\n");
    }

    @Override
    public String description() {
        return "Permet d'enregistrer un nouveau patient.";
    }
}
