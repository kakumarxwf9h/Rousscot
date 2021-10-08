package hospital.exception;

import java.util.NoSuchElementException;

/**
 * I am raise went a patient is not found. I keep the name of this patient.
 */
public class PatientNotFoundException extends NoSuchElementException {
    protected final String name;

    public PatientNotFoundException(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
