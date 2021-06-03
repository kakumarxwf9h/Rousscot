package hospital.factory;

import hospital.domaine.Patient;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ferlicotdelbe on 23/10/15.
 */
public class PatientFactory {
    private static PatientFactory INSTANCE = new PatientFactory();

    public static PatientFactory current() {
        return INSTANCE;
    }

    protected Set<Patient> patients;

    private PatientFactory() {
        this.patients = new HashSet<Patient>();
    }
}
