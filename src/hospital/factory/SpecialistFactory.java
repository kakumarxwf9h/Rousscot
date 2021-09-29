package hospital.factory;

import hospital.domaine.Specialist;
import hospital.domaine.Speciality;
import hospital.exception.SpecialistNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 */
public class SpecialistFactory {
    private static SpecialistFactory INSTANCE = new SpecialistFactory();
    public Set<Specialist> specialists;

    private SpecialistFactory() {
        this.specialists = new HashSet<Specialist>();
    }

    public static SpecialistFactory current() {
        return INSTANCE;
    }

    /**
     * @param name the name of the Specialist to return
     * @return the Specialist with the given name, else null
     * @throws SpecialistNotFoundException if no specialist have this name.
     */
    public Specialist specialistNamed(String name) throws SpecialistNotFoundException {
        for (Specialist s : specialists) {
            if (s.getName().toLowerCase().equals(name.toLowerCase())) {
                return s;
            }
        }
        throw new SpecialistNotFoundException(name);
    }

    /**
     * Create a Specialist and add it in "specialists"
     *
     * @param name       the name to set
     * @param speciality the speciality to set
     */
    public Specialist createSpecialist(String name, Speciality speciality) {
        Specialist specialist = new Specialist(name, speciality);
        specialists.add(specialist);
        return specialist;
    }

    /**
     * TODo
     *
     * @return
     */
    public Collection<Specialist> specialists() {
        return this.specialists;
    }

    public Specialist specialistFor(Speciality speciality) {
        for (Specialist specialist : this.specialists) {
            if (specialist.getSpeciality().equals(speciality)) {
                return specialist;
            }
        }
        return null;
    }

    public boolean canRegisterSpecialistNamed(String name) {
        for (Specialist s : specialists) {
            if (s.getName().toLowerCase().equals(name.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
