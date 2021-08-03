package hospital.metier;

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
        SpecialistFactory.current().createSpecialist(name, speciality);
    }

    /*
    * TODO
     */
    public Speciality getSpeciality(BufferedReader br) throws IOException {
        System.out.println(Speciality.allSpeciality() + '\n' + "Sp�cialit� : ");
        Speciality speciality = Speciality.forInput(br.readLine().toLowerCase());
        while (speciality == null) {
            System.out.println("Pas de sp�cialit� de ce nom. ");
            speciality = this.getSpeciality(br);
        }
        return speciality;
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer un nouveau sp�cialiste.");
    }
}