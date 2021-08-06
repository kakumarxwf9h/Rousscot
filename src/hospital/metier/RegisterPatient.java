package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 * @author Cyril Ferlicot & Aur�lien Rousseau
 */
public class RegisterPatient extends ActionForPerson {

    protected final static String COMMAND = "enregistrer";

    @Override
    public void action(BufferedReader br, String name) throws IOException {
        System.out.println("Num�ro de S�curit� Social: ");
        Long ss = Long.parseLong(br.readLine());
        System.out.println("Adresse: ");
        String address = br.readLine();
        System.out.println("Age: ");
        Integer age = Integer.parseInt(br.readLine());
        Patient patient = PatientFactory.current().createPatient(name,ss,address,age);
        System.out.println("Patient nommé " + patient.lastName() + " créé.\n");
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer un nouveau patient.");
    }
}
