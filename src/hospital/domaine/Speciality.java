package hospital.domaine;

/**
 * Created by rousseaua on 23/10/15.
 */
public enum Speciality {
    CARDIOLOGIE, CHIRURGIE, DERMATOLOGIE;

    /*
    * TODO
     */
    public static String allSpeciality() {
        String result = "Spécialités : ";
        for (Speciality speciality : Speciality.values()) {
            result = result + speciality + " ; "; //Can be improve
        }
        return result;
    }

    /*
    * TODO
     */
    public static Speciality forInput(String input) {
        //TODO something doesn't work
        for (Speciality speciality : Speciality.values()) {
            if (input.equals(speciality.toString().toLowerCase())) {
                return speciality;
            }
        }
        return null;
    }
}
