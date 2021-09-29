package hospital.exception;

import java.util.NoSuchElementException;

/**
 * I am raise went a specialist is not found. I keep the name of this specialist.
 */
public class SpecialistNotFoundException extends NoSuchElementException {
    protected String name;

    public SpecialistNotFoundException(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
