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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialist that = (Specialist) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return speciality == that.speciality;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        return result;
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
