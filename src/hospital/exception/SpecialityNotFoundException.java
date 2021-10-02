package hospital.exception;

import java.util.NoSuchElementException;

/**
 * I am raise if a speciality is not found.
 */
public class SpecialityNotFoundException extends NoSuchElementException {
    protected final String speciality;

    public SpecialityNotFoundException(String speciality) {
        this.speciality = speciality;
    }

    public String speciality() {
        return this.speciality;
    }
}
