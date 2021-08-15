package hospital.metier;

import hospital.domaine.Specialist;
import hospital.domaine.Speciality;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class RegisterSpecialist extends ActionForPerson {

    protected final static String COMMAND = "enregistrer";

    /*
    * TODO
     */
    @Override
    public void action(BufferedReader br, String name) throws IOException {
        Speciality speciality = getSpeciality(br);
        Specialist specialist = SpecialistFactory.current().createSpecialist(name, speciality);
        System.out.println("Spécialiste " + specialist.getName() +" engagé.");
    }

    /*
    * TODO
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
    public void description() {
        System.out.println("Permet d'enregistrer un nouveau sp�cialiste.");
    }
}
