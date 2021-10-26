package hospital.domaine;

import hospital.exception.IllegalReportException;
import hospital.exception.PatientNotAtHospitalException;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 */
public class StayCard {

    Map<Speciality, Report> specialityReportMap;

    protected Patient patient;

    public StayCard(Patient patient) {
        specialityReportMap = new HashMap<Speciality, Report>();
        this.patient = patient;
    }

    /**
     * todo
     *
     * @param speciality
     * @param report
     */
    public void addReportToSpeciality(Speciality speciality, Report report) throws IllegalReportException, PatientNotAtHospitalException {
        if (!this.specialityReportMap.containsKey(speciality) || this.specialityReportMap.get(speciality) != null) {
            throw new IllegalReportException(this.specialityReportMap.containsKey(speciality));
        }
        this.specialityReportMap.put(speciality, report);
    }

    public int numberOfVisitDone() {
        int cpt = 0;
        for (Report r : this.specialityReportMap.values()) {
            if (r != null) {
                cpt++;
            }
        }
        return cpt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StayCard stayCard = (StayCard) o;

        if (specialityReportMap != null ? !specialityReportMap.equals(stayCard.specialityReportMap) : stayCard.specialityReportMap != null)
            return false;
        return !(patient != null ? !patient.equals(stayCard.patient) : stayCard.patient != null);

    }

    @Override
    public int hashCode() {
        int result = specialityReportMap != null ? specialityReportMap.hashCode() : 0;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        return result;
    }

    public void printConsultations() {
        System.out.println("Carte de sÃ©jour du patient: " + this.numberOfVisitDone() + " consultation(s) visitÃ©e(s).");
        for (Speciality s : this.specialityReportMap.keySet()) {
            Report report = this.specialityReportMap.get(s);
            if (report != null) {
                System.out.println("  -" + s);
                report.printReport();
            }
        }
        this.specialityReportMap.keySet().stream().filter(s -> this.specialityReportMap.get(s) == null).forEach(s -> {
            System.out.println("  -" + s + " Consultation à effectuer");
        });
    }

    /**
     * Add a consultation for a specibality.
     * @param speciality the speciality.
     * @throws PatientNotAtHospitalException if the patient is not at the hospital.
     */
    public void needConsultationFor(Speciality speciality) throws PatientNotAtHospitalException {
        if (specialityReportMap.containsKey(speciality)) {
            System.out.println("La carte de séjour contient déjà la spécialité.");
        } else {
            specialityReportMap.put(speciality, null);
        }
    }

    /**
     * Return a boolean. True if the patient still need a consultation or not.
     * @return Return a boolean. True if the patient still need a consultation or not.
     * @throws PatientNotAtHospitalException if the patient is not at the hospital.
     */
    public boolean stillNeedConsultation() throws PatientNotAtHospitalException {
        for (Report report : this.specialityReportMap.values()) {
            if (report == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return if the patient is at the hospital.
     * @return Return if the patient is at the hospital.
     */
    public boolean isAtHospital() {
        return true;
    }
}
