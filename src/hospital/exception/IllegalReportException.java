package hospital.exception;

/**
 * I am raise if there is a problem with a report. I know if it's because the patient can't consult or if he already consulted.
 */
public class IllegalReportException extends Exception {

    protected final Boolean hasConsult;

    public IllegalReportException(boolean alreadyConsult) {
        this.hasConsult = alreadyConsult;
    }

    public Boolean alreadyConsulted() {
        return this.hasConsult;
    }

}
