package hospital.metier;

import hospital.domaine.Speciality;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class RegisterSpecialist extends Action {

    protected final static String COMMAND = "registerS";

    /*
    * TODO
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Nom du spécialiste: ");
        String name = br.readLine();
        Speciality speciality = getSpeciality(br);
        SpecialistFactory.current().createSpecialist(name, speciality);
    }

    /*
    * TODO
     */
    public Speciality getSpeciality(BufferedReader br) throws IOException {
        System.out.println(Speciality.allSpeciality() + '\n' + "Spécialité : ");
        Speciality speciality = Speciality.forInput(br.readLine());
        while (speciality == null) {
            System.out.println("Pas de spécialité de ce nom. ");
            speciality = this.getSpeciality(br);
        }
        return speciality;
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer un nouveau spécialiste.");
    }
}
