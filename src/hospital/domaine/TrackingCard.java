package hospital.domaine;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class TrackingCard {

    protected Set<Report> reports;

    public TrackingCard() {
        this.reports = new HashSet<>();
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void addReport(Report report) {
        this.reports.add(report);
    }

    @Override
    public String toString() {
        return "aTrackingCard{" +
                "reports=" + reports +
                '}';
    }
}
