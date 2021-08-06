package hospital.metier;

import hospital.domaine.Patient;
import hospital.factory.PatientFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

/**
 * //TODO
 */
public class ListPatient extends Action{

    protected final static String COMMAND = "ListePatient";

    /**
     * //TODO
     * @param br
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Liste des patients: ");
        Collection<Patient> patients = PatientFactory.current().patients();
        for(Patient patient : patients ){
            System.out.print(patient.lastName());
            if(patient.isAtTheHospital()){
                System.out.println(" en cours d'hospitalisation.");
            } else {
                System.out.println(" n'est pas à l'hôpital.");
            }
        }
        if ( Integer.valueOf(patients.size()).equals(0)) {
            System.out.println("Aucun patient enregistré.");
        }
        System.out.println();
    }

    @Override
    public void description() {
        System.out.println("Permet d'afficher la liste des patient et de savoir s'ils sont y l'hôpital en ce moment.");
    }
}
