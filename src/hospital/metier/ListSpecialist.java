package hospital.metier;

import hospital.domaine.Specialist;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

/**
 * I am a class that list the specialists
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class ListSpecialist extends Action {

    protected final static String COMMAND = "ListeSpecialiste";

    /**
     * I list the specialists
     *
     * @param br a BufferedReader
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Liste des spécialistes: ");
        Collection<Specialist> specialists = SpecialistFactory.current().specialists();
        for (Specialist specialist : specialists) {
            System.out.print(specialist.getName() + " ( " + specialist.getSpeciality().toString().toLowerCase() + " ) ");
        }
        if (Integer.valueOf(specialists.size()).equals(0)) {
            System.out.println("Aucun spécialiste enregistré.");
        }
        System.out.println();
    }

    @Override
    public void description() {
        System.out.println("Permet d'afficher la liste des spécialistes et leur spécialité.");
    }
}
