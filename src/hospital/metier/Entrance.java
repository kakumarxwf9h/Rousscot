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
 * @author Cyril Ferlicot & Aur�lien Rousseau
 */
public class Entrance extends ActionForPerson {

    protected final static String COMMAND = "Entree";

    /*
    *   I register a Patient. If the patient is not on the base I call RegisterPatient.
    *
    *   @param br a BufferedReader if the action need to interact with the user.
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        Patient patient = getPatientNamed(name, br);
        this.createStayCardFor(patient, br);
        System.out.println("Enregistrement de " + patient.lastName() + " termin�.");
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
        System.out.print("Sp�cialit� (taper 'aide' pour avoir la liste ou 'fini' pour terminer l'enregistrement) : ");
        this.manageSpecialityNamed(br.readLine(), stayCard, br);
    }

    /*
    *   TODO
     */
    public Object manageSpecialityNamed(String input, StayCard stayCard, BufferedReader br) throws IOException {
        //Can be better but that will do it for now.
        String inpt = input.toLowerCase().trim();
        if( inpt.equals("aide")){
            System.out.println(Speciality.allSpeciality());
            this.addSpecialityTo(stayCard,br);
            return null;
        }

        if(inpt.equals("fini")){
            return null;
        }
        //TODO NE�FONCTIONNE�PAS
        Speciality speciality = Speciality.forInput(inpt);

        if(!(speciality == null)){
            //todo c'est �a que tu voulais ?
//            stayCard.newTrackingCardFor(speciality);
            stayCard.addSpeciality(speciality);
            this.addSpecialityTo(stayCard, br);
            return null;
        }

        System.out.println("Cette sp�cialit� n'existe pas. Utilisez 'aide' pour plus d'information.");
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
            System.out.println("Premi�re visite, enregistrement du patient.");
                    (new RegisterPatient()).action(br, name);
            return this.getPatientNamed(name, br);
        }
        return patient;
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer l'entr�e d'un patient.");
    }
}
