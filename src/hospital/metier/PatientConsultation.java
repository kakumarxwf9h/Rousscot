package hospital.metier;

import hospital.domaine.Patient;
import hospital.domaine.Specialist;
import hospital.domaine.Speciality;
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
        Patient patient = PatientFactory.current().patientNamed(name);
        if (patient == null) {
            System.out.println("Aucun patient de ce nom.\n");
        } else {
            System.out.println("Spécialité ?");
            Speciality speciality = this.getSpeciality(br);
            Specialist specialist = SpecialistFactory.current().specialistFor(speciality);
            if (specialist == null) {
                System.out.println("Désolé mais aucun spécialiste ne peut s'occuper de vous pour le moment.\n");
            } else {
                (new Consultation()).makeConsultation(patient, specialist, br);
            }
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
        Speciality speciality = Speciality.forInput(br.readLine().toLowerCase());
        while (speciality == null) {
            System.out.println("Pas de spÃ©cialitÃ© de ce nom. ");
            speciality = this.getSpeciality(br);
        }
        return speciality;
    }

    @Override
    public void description() {
        System.out.println("Permet de consulter un spécialiste.");
    }
}
