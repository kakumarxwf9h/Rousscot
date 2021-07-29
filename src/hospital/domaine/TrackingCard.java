package hospital.domaine;

import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class TrackingCard {

    protected Set<Report> reports;

    public TrackingCard(Set<Report> reports) {
        this.reports = reports;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }
}
