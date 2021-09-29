package hospital.factory;

import hospital.domaine.Patient;
import hospital.exception.PatientNotFoundException;

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

    /**
     *
     * @param name
     * @return the Patient with the given name, else nul.
     * @throws PatientNotFoundException if the patient is not found.
     */
    public Patient patientNamed(String name) throws PatientNotFoundException {
    	for(Patient p : patients){
    		if(p.lastName().toLowerCase().equals(name.toLowerCase())){
    			return p;
    		}
    	}
        throw new PatientNotFoundException(name);
    }

    /**
     * Create a Patient and add it to "patients"
     * @param name
     * @param ss
     * @param address
     * @param age
     */
    public Patient createPatient(String name, Long ss, String address, Integer age) {
        Patient patient =new Patient(name, ss, address, age);
        patients.add(patient);
        return patient;
    }

    /**
     * //TODO
     * @return
     */
    public Set<Patient> patients() {
        return this.patients;
    }

    public boolean canRegisterPatientNamed(String name) {
        for(Patient p : patients){
            if(p.lastName().toLowerCase().equals(name.toLowerCase())){
                return false;
            }
        }
        return true;
    }
}
