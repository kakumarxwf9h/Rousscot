package hospital.factory;

import hospital.domaine.Patient;
import hospital.domaine.Report;
import hospital.domaine.Specialist;
import hospital.exception.IllegalReportException;

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
     *
     * @param date
     * @param content
     * @return the Report created
     */
    private Report createReport(Date date, String content) {
        Report report = new Report(date, content);
        return report;
    }


    public void createReport(Patient patient, Specialist specialist, String content) throws IllegalReportException {
            Report report = createReport(new Date(), content);
            patient.addReportFor(specialist.getSpeciality(), report);
            this.reports.add(report);
    }
}
