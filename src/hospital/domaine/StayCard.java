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

    public void needConsultationFor(Speciality speciality) throws PatientNotAtHospitalException {
        if (specialityReportMap.containsKey(speciality)) {
            System.out.println("La carte de séjour contient déjà la spécialité.");
        } else {
            specialityReportMap.put(speciality, null);
        }
    }

    public boolean stillNeedConsultation() throws PatientNotAtHospitalException {
        for (Report report : this.specialityReportMap.values()) {
            if (report == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isAtHospital() {
        return true;
    }
}
