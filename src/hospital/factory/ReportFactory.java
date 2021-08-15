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
     *
     * @param date
     * @param content
     * @return the Report created
     */
    public Report createReport(Date date, String content) {
        Report report = new Report(date, content);
        reports.add(report);
        return report;
    }


    public void createReport(Patient patient, Specialist specialist, String s) {
        //TODO
        Report report = createReport(new Date(), s);
        for (Patient p : PatientFactory.current().patients) {
            if(p.lastName()==patient.lastName()){
                p.getStayCard().addReportToSpeciality(specialist.getSpeciality(), report);
            }
        }
    }
}
