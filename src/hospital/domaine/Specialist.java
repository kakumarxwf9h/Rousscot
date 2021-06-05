package hospital.domaine;

/**
 * Created by rousseaua on 23/10/15.
 */
public class Specialist {

    protected String name;
    protected Speciality speciality;

    public Specialist(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
