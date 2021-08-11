package hospital.domaine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rousseaua on 23/10/15.
 */
public class StayCard {

    Map<Speciality, Report> specialityReportMap;

    public StayCard() {
        specialityReportMap = new HashMap<Speciality, Report>();
    }

    public void addSpeciality(Speciality speciality) {
        if (specialityReportMap.containsKey(speciality)) {
            System.out.println("La carte de s�jour contient d�j� la sp�cialit�.");
        } else {
            specialityReportMap.put(speciality, null);
        }
    }
}
