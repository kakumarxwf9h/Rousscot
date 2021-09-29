package hospital.metier;

import hospital.domaine.Specialist;
import hospital.domaine.Speciality;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am a class that allow to create a specialist.
 *
 * @author Cyril Ferlicot & Aur�lien Rousseau
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
        if(SpecialistFactory.current().canRegisterSpecialistNamed(name)){
            Speciality speciality = getSpeciality(br);
            Specialist specialist = SpecialistFactory.current().createSpecialist(name, speciality);
            System.out.println("Sp�cialiste " + specialist.getName() + " engag�.\n");
        }
        else {
            System.out.println("Un sp�cialiste du m�me nom existe d�j�, il ne peut y avoir d'homonyme.");
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
        System.out.println(Speciality.allSpeciality() + '\n' + "Spécialité : ");
        Speciality speciality = Speciality.forInput(br.readLine().toLowerCase());
        while (speciality == null) {
            System.out.println("Pas de spécialité de ce nom. ");
            speciality = this.getSpeciality(br);
        }
        return speciality;
    }

    @Override
    public String description() {
        return "Permet d'enregistrer un nouveau sp�cialiste.";
    }
}
