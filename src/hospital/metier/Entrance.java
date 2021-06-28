package hospital.metier;

import hospital.domaine.Patient;
import hospital.domaine.Speciality;
import hospital.domaine.StayCard;
import hospital.factory.PatientFactory;
import hospital.factory.StayCardFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am an action that manage the entrance of a Patient.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class Entrance extends Action {

    protected final static String COMMAND = "entrance";

    /*
    *   I register a Patient. If the patient is not on the base I call RegisterPatient.
    *
    *   @param br a BufferedReader if the action need to interact with the user.
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.print("Nom du patient: ");
        String name = br.readLine();
        Patient patient = getPatientNamed(name, br);
        this.createStayCardFor(patient, br);
        System.out.println("Enregistrement de " + patient.lastName() + " terminé.");
    }

    /*
    *   I create a StayCard for a patient.
    *   @param patient the patient that needs the stay card.
     */
    public void createStayCardFor(Patient patient, BufferedReader br) throws IOException {
        StayCard stayCard = StayCardFactory.current().newStayCardFor(patient);
        addSpecialityTo(stayCard, br);
    }

    public void addSpecialityTo(StayCard stayCard, BufferedReader br) throws IOException {
        System.out.print("Spécialité (taper 'aide' pour avoir la liste ou 'fini' pour terminer l'enregistrement) : ");
        this.manageSpecialityNamed(br.readLine(), stayCard, br);
    }

    /*
    *   TODO
     */
    public Object manageSpecialityNamed(String input, StayCard stayCard, BufferedReader br) throws IOException {
        //Can be better but that will do it for now.
        String inpt = input.toLowerCase().trim();
        if( inpt.equals("aide")){
            System.out.print("Spécialités : ");
            for(Speciality speciality : Speciality.values()){
                System.out.print(speciality + " ; ");
            }
            System.out.println();
            this.addSpecialityTo(stayCard,br);
            return null;
        }

        if(inpt.equals("fini")){
            return null;
        }

        for(Speciality speciality : Speciality.values()){
            if(inpt.equals(speciality.toString().toLowerCase())){
                stayCard.newTrackingCardFor(speciality);
                this.addSpecialityTo(stayCard, br);
                return null;
            }
        }

        System.out.println("Cette spécialité n'existe pas. Utilisez 'aide' pour plus d'information.");
        this.addSpecialityTo(stayCard, br);
        return null;
    }

    /*
    *   I get a Patient from his name. If there is no patient I allow the user to register him.
    *   @param patient the patient name.
    *   @return an object Patient
     */
    public Patient getPatientNamed(String name, BufferedReader br) throws IOException {
        Patient patient = PatientFactory.current().patientNamed(name);
        if (patient == null) {
            (new RegisterPatient()).action(br);
            patient = PatientFactory.current().patientNamed(name);
        }
        return patient;
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer l'entrée d'un patient.");
    }
}
