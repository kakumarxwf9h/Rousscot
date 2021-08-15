package hospital.domaine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class StayCard {

    Map<Speciality, Report> specialityReportMap;

    public StayCard() {
        specialityReportMap = new HashMap<Speciality, Report>();
    }

    //todo doc
    public void addSpeciality(Speciality speciality) {
        if (specialityReportMap.containsKey(speciality)) {
            System.out.println("La carte de séjour contient déjà la spécialité.");
        } else {
            specialityReportMap.put(speciality, null);
        }
    }

    //todo doc
    public void addReportToSpeciality(Speciality speciality, Report report) {
        for (HashMap.Entry<Speciality, Report> entry : specialityReportMap.entrySet()) {
            if (entry.getKey() == speciality) {
                entry.setValue(report);
            }
        }
    }
}
