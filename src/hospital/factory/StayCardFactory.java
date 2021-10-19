package hospital.factory;

import hospital.domaine.Patient;
import hospital.domaine.StayCard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class StayCardFactory {
    private static StayCardFactory INSTANCE = new StayCardFactory();

    public static StayCardFactory current() {
        return INSTANCE;
    }

    protected Set<StayCard> stayCards;

    private StayCardFactory() {
        this.stayCards = new HashSet<StayCard>();
    }

    public StayCard newStayCardFor(Patient patient) {
        StayCard stayCard = new StayCard(patient);
        this.stayCards.add(stayCard);
        return stayCard;
    }

    public void destroy(StayCard stayCard) {
        this.stayCards.remove(stayCard);
    }
}
