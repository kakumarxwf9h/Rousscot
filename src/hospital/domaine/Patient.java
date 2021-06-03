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
}
