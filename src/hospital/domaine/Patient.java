package hospital.domaine;

/**
 * Created by ferlicotdelbe on 23/10/15.
 */
public class Patient {

    protected String last_name;

    protected Long numSS;

    protected String address;

    protected Integer age;

    public Patient(String name, Long numSS, String address, Integer age) {
        this.address = address;
        this.last_name = name;
        this.age = age;
        this.numSS = numSS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        return !(last_name != null ? !last_name.equals(patient.last_name) : patient.last_name != null) && !(numSS != null ? !numSS.equals(patient.numSS) : patient.numSS != null) && !(address != null ? !address.equals(patient.address) : patient.address != null) && !(age != null ? !age.equals(patient.age) : patient.age != null);

    }

    @Override
    public int hashCode() {
        int result = last_name != null ? last_name.hashCode() : 0;
        result = 31 * result + (numSS != null ? numSS.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public String lastName() {
        //TODO accessor
        return null;
    }

    public void destroyStayingCard() {
        //TODO
    }

    public void printStayingCard() {
        //TODO I print the staying card of the patient and the tracking cards.
        //TODO If the patient don't have one I could maybe use a Null Object Pattern :)
    }
}
