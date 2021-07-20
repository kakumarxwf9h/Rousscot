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

    public Patient patientNamed(String name) {
    	for(Patient p : patients){
    		if(p.lastName().equals(name)){
    			return p;
    		}
    	}
        return null;
    }

    public void createPatient(String name, Long ss, String address, Integer age) {
        patients.add(new Patient(name, ss, address, age));
    }
}
