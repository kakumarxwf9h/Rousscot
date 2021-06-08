package hospital.domaine;

import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class TrackingCard extends Card{
    protected Report report;

    public TrackingCard(Patient patient, Set<Speciality> specialities, Report report) {
        super(patient, specialities);
        this.report = report;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
