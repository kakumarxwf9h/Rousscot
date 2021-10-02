package hospital.exception;

import hospital.domaine.Patient;

/**
 * I am raise if the patient is at the hospital and cannot do something..
 */
public class PatientAtHospitalException extends Exception {
    protected final Patient patient;

    public PatientAtHospitalException(Patient patient) {
        this.patient = patient;
    }
}
