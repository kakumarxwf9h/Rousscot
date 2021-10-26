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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackingCard that = (TrackingCard) o;

        return !(reports != null ? !reports.equals(that.reports) : that.reports != null);

    }

    @Override
    public int hashCode() {
        return reports != null ? reports.hashCode() : 0;
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
