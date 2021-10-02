package hospital.metier;

import hospital.domaine.Patient;
import hospital.domaine.Specialist;
import hospital.domaine.Speciality;
import hospital.exception.PatientNotFoundException;
import hospital.exception.SpecialityNotFoundException;
import hospital.factory.PatientFactory;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am a class that manage a consultation asked by a patient.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class PatientConsultation extends ActionForPerson {

    protected static final String COMMAND = "consultation";

    @Override
    public void action(BufferedReader br, String name) throws IOException {
        try {
            Patient patient = PatientFactory.current().patientNamed(name);
            System.out.println("Spécialité ?");
            Speciality speciality = this.getSpeciality(br);
            Specialist specialist = SpecialistFactory.current().specialistFor(speciality);
            if (specialist == null) {
                System.out.println("Désolé mais aucun spécialiste ne peut s'occuper de vous pour le moment.\n");
            } else {
                (new Consultation()).makeConsultation(patient, specialist, br);
            }
        } catch (PatientNotFoundException e) {
            System.out.println("Aucun patient de ce nom.\n");
        }

    }

    /**
     * I ask to the user a speciality.
     *
     * @param br
     * @return a Speciality enter by the user.
     * @throws IOException
     */
    public Speciality getSpeciality(BufferedReader br) throws IOException {
        System.out.println(Speciality.allSpeciality() + '\n' + "SpÃ©cialitÃ© : ");
        try {
            Speciality speciality = Speciality.forInput(br.readLine().toLowerCase());
            return speciality;
        } catch (SpecialityNotFoundException e) {
            System.out.println("Pas de spÃ©cialitÃ© de ce nom: " + e.speciality() + ". ");
            return this.getSpeciality(br);
        }
    }

    @Override
    public String description() {
        return "Permet de consulter un spécialiste.";
    }
}
