package hospital.domaine;

import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class StayCard extends Card {
    public StayCard(Patient patient, Set<Speciality> specialities) {
        super(patient, specialities);
    }

    public void newTrackingCardFor(Speciality speciality) {
        //TODO create a Tracking card for the speciality.
    }
}
