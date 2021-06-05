package hospital.domaine;

import java.util.Date;

/**
 * Created by rousseaua on 23/10/15.
 */
public class Report {
    protected Date date;
    protected String report;

    public Report(Date date, String report) {
        this.date = date;
        this.report = report;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
