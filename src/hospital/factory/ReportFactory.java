package hospital.factory;

import hospital.domaine.Patient;
import hospital.domaine.Report;
import hospital.domaine.Specialist;

import java.util.Date;
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

    /**
     * Create a Report and add it in "reports"
     * @param date
     * @param report
     */
    public void createReport(Date date, String report) {
        reports.add(new Report(date, report));
    }


    public void createReport(Patient patient, Specialist specialist, String s) {
        //TODO
    }
}
