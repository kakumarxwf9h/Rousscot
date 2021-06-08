package hospital.factory;

import hospital.domaine.TrackingCard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class TrackingCardFactory {
    private static TrackingCardFactory INSTANCE = new TrackingCardFactory();

    public static TrackingCardFactory current() {
        return INSTANCE;
    }

    protected Set<TrackingCard> trackingCards;

    private TrackingCardFactory() {
        this.trackingCards = new HashSet<TrackingCard>();
    }
}
