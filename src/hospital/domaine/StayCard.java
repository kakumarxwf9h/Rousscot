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

    //todo doc
    public void addSpeciality(Speciality speciality) {
        if (specialityReportMap.containsKey(speciality)) {
            System.out.println("La carte de s�jour contient d�j� la sp�cialit�.");
        } else {
            specialityReportMap.put(speciality, null);
        }
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
}
