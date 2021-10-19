package hospital.domaine;

import hospital.exception.IllegalReportException;
import hospital.exception.PatientNotAtHospitalException;

/**
 * I am a StayCard use when the patient is not at the hospital.
 */
public class NullStayCard extends StayCard {

    public NullStayCard(Patient patient) {
        super(patient);
    }

    public void printConsultations() {
        System.out.println("Le patient ne possède pas de carte de séjour.");
    }

    public void addReportToSpeciality(Speciality speciality, Report report) throws IllegalReportException, PatientNotAtHospitalException {
       throw new PatientNotAtHospitalException(patient);
    }

    public boolean isAtHospital() {
        return false;
    }

    public int numberOfVisitDone() {
        return 0;
    }

    public void needConsultationFor(Speciality speciality) throws PatientNotAtHospitalException{
       throw new PatientNotAtHospitalException(patient);
    }

    public boolean stillNeedConsultation() throws PatientNotAtHospitalException {
        throw new PatientNotAtHospitalException(patient);
    }
}
