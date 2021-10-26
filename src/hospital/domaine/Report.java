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

    public String getReport() {
        return report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report1 = (Report) o;

        if (date != null ? !date.equals(report1.date) : report1.date != null) return false;
        return !(report != null ? !report.equals(report1.report) : report1.report != null);

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (report != null ? report.hashCode() : 0);
        return result;
    }

    public void printReport() {
        System.out.println("--------------------");
        System.out.println("COMPTE RENDU DU " + this.getDate());
        System.out.println("RAPPORT: " + this.getReport());
        System.out.println("FIN DU COMPTE RENDU");
    }
}
