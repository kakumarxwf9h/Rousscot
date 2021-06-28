package hospital.domaine;

import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public abstract class Card {
    protected Patient patient;
    protected Set<Speciality> specialities;

    public Card(Patient patient, Set<Speciality> specialities) {
        this.patient = patient;
        this.specialities = specialities;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

}
