package hospital.exception;


import hospital.domaine.Patient;

/**
 * I am raise if the patient is not at the hospital and cannot do something..
 */
public class PatientNotAtHospitalException extends Exception {
    protected final Patient patient;

    public PatientNotAtHospitalException(Patient patient) {
        this.patient = patient;
    }

    public String name(){
       return patient.lastName();
    }
}
