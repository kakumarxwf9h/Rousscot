package hospital.factory;

import hospital.domaine.Patient;
import hospital.domaine.Report;
import hospital.domaine.Specialist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class ReportFactory {

    private static ReportFactory INSTANCE = new ReportFactory();

    public static ReportFactory current() {
        return INSTANCE;
    }

    protected Set<Report> reports;

    private ReportFactory() {
        this.reports = new HashSet<Report>();
    }

    public void createReport(Patient patient, Specialist specialist, String report) {
        //TODO
    }
}
