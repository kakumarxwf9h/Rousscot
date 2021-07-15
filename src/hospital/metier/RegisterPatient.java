package hospital.metier;

import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class RegisterPatient extends Action {

    protected final static String COMMAND = "register";

    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Nom du patient: ");
        String name = br.readLine();
        System.out.println("Numéro de Sécurité Social: ");
        Long ss = Long.parseLong(br.readLine());
        System.out.println("Adresse: ");
        String address = br.readLine();
        System.out.println("Age: ");
        Integer age = Integer.parseInt(br.readLine());
        PatientFactory.current().createPatient(name,ss,address,age);
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer un nouveau patient.");
    }
}
