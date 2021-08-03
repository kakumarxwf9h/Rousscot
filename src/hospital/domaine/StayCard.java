package hospital.domaine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rousseaua on 23/10/15.
 */
public class StayCard {

    Map<Speciality, Report> specialityReportMap;

    public StayCard() {
        specialityReportMap = new HashMap<>();
    }

    public void addSpeciality(Speciality speciality) {
        if (specialityReportMap.containsKey(speciality)) {
            System.out.println("La carte de séjour contient déjà la spécialité.");
        } else {
            specialityReportMap.put(speciality, null);
        }
    }
}
