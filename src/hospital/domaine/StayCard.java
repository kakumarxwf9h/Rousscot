package hospital.domaine;

import hospital.exception.IllegalReportException;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 */
public class StayCard {

    Map<Speciality, Report> specialityReportMap;

    public StayCard() {
        specialityReportMap = new HashMap<Speciality, Report>();
    }

    /**
     * todo
     *
     * @param speciality
     * @param report
     */
    public void addReportToSpeciality(Speciality speciality, Report report) throws IllegalReportException {
        if (this.specialityReportMap.get(speciality) != null) {
            throw new IllegalReportException();
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

    public void needConsultationFor(Speciality speciality) {
        if (specialityReportMap.containsKey(speciality)) {
            System.out.println("La carte de séjour contient déjà la spécialité.");
        } else {
            specialityReportMap.put(speciality, null);
        }
    }
}
