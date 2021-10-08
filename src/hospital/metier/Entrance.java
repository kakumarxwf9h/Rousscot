package hospital.metier;

import hospital.domaine.Patient;
import hospital.domaine.Speciality;
import hospital.exception.PatientAtHospitalException;
import hospital.exception.PatientNotFoundException;
import hospital.exception.SpecialityNotFoundException;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am an action that manage the entrance of a Patient.
 *
 * @author Cyril Ferlicot & Aur�lien Rousseau
 */
public class Entrance extends ActionForPerson {

    protected final static String COMMAND = "entree";

    /**
     * I register a Patient. If the patient is not on the base I call RegisterPatient.
     *
     * @param br   a BufferedReader if the action need to interact with the user.
     * @param name The name of the person
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        Patient patient = getPatientNamed(name, br);
        try {
            patient.goToHospital();
            this.addSpecialityTo(patient, br);
            System.out.println("Enregistrement de " + patient.lastName() + " termin�.\n");
        } catch (PatientAtHospitalException e) {
            System.out.println("Patient déjà à l'hôpital.\n");
        }
    }

    /**
     * I ask to the user which specialty needs the patient.
     * I manage a String that enter the user.
     * If this string is a command I execute it. Else I add the speciality to the stay card of the patient, if possible.
     *
     * @param patient the patient
     * @param br      a BufferedReader
     * @return nothing, I return only null to avoid too many if.
     * @throws IOException
     */
    public Object addSpecialityTo(Patient patient, BufferedReader br) throws IOException {
        System.out.print("Sp�cialit� (taper 'aide' pour avoir la liste ou 'fini' pour terminer l'enregistrement) : ");
        String input = br.readLine();

        //Can be better but that will do it for now.
        String inpt = input.toLowerCase().trim();
        if (inpt.equals("aide")) {
            System.out.println(Speciality.allSpeciality());
            this.addSpecialityTo(patient, br);
            return null;
        }

        if (inpt.equals("fini")) {
            return null;
        }

        try {
            Speciality speciality = Speciality.forInput(inpt);
            patient.needConsultationFor(speciality);
            this.addSpecialityTo(patient, br);
        } catch (SpecialityNotFoundException e) {
            System.out.println("Cette sp�cialit� n'existe pas: " + e.speciality() + ". Utilisez 'aide' pour plus d'information.");
            this.addSpecialityTo(patient, br);
        }


        return null;
    }

    /**
     * I get a Patient from his name. If there is no patient I allow the user to register him.
     *
     * @param name the patient name.
     * @param br   a BufferedReader
     * @return an object Patient
     */
    public Patient getPatientNamed(String name, BufferedReader br) throws IOException {
        try {
            Patient patient = PatientFactory.current().patientNamed(name);
            return patient;
        } catch (PatientNotFoundException e) {
            System.out.println("Premi�re visite, enregistrement du patient.");
            (new RegisterPatient()).action(br, e.name());
            return this.getPatientNamed(e.name(), br);
        }
    }

    @Override
    public String description() {
        return "Permet d'enregistrer l'entr�e d'un patient.";
    }
}
