package hospital.metier;

import hospital.domaine.Patient;
import hospital.domaine.Specialist;
import hospital.factory.PatientFactory;
import hospital.factory.SpecialistFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

/**
 * //TODO
 */
public class ListSpecialist extends Action{

    protected final static String COMMAND = "ListeSpecialiste";

    /**
     * //TODO
     * @param br
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Liste des spécialistes: ");
        Collection<Specialist> specialists = SpecialistFactory.current().specialists();
        for(Specialist specialist : specialists ){
            System.out.print(specialist.getName() + " ( " + specialist.getSpeciality().toString().toLowerCase() + " ) ");
        }
        if ( Integer.valueOf(specialists.size()).equals(0)) {
            System.out.println("Aucun spécialiste enregistré.");
        }
        System.out.println();
    }

    @Override
    public void description() {
        System.out.println("Permet d'afficher la liste des spécialistes et leur spécialité.");
    }
}
