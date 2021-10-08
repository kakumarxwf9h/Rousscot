package hospital.domaine;

import hospital.exception.SpecialityNotFoundException;

/**
 * Created by rousseaua on 23/10/15.
 */
public enum Speciality {
    CARDIOLOGIE, CHIRURGIE, DERMATOLOGIE;

    /*
    * TODO
     */
    public static String allSpeciality() {
        StringBuilder result = new StringBuilder("Spécialités : ");
        for (Speciality speciality : Speciality.values()) {
            result.append(speciality + " ; ");
        }
        return result.toString();
    }

    public static Speciality forInput(String input) {
        for (Speciality speciality : Speciality.values()) {
            if (input.equals(speciality.toString().toLowerCase())) {
                return speciality;
            }
        }
        throw new SpecialityNotFoundException(input);
    }
}
