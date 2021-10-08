package hospital.metier;

import hospital.domaine.Specialist;
import hospital.domaine.Speciality;
import hospital.exception.SpecialityNotFoundException;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am a class that allow to create a specialist.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class RegisterSpecialist extends ActionForPerson {

    protected final static String COMMAND = "enregistrer";

    /**
     * I am a method use to create a specialist.
     *
     * @param br
     * @param name the name of the specialist.
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        if (SpecialistFactory.current().canRegisterSpecialistNamed(name)) {
            Speciality speciality = getSpeciality(br);
            Specialist specialist = SpecialistFactory.current().createSpecialist(name, speciality);
            System.out.println("Spécialiste " + specialist.getName() + " engagé.\n");
        } else {
            System.out.println("Un spécialiste du même nom existe déjà, il ne peut y avoir d'homonyme.");
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
        return "Permet d'enregistrer un nouveau spï¿½cialiste.";
    }
}
