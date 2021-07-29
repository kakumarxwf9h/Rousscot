package hospital.factory;

import hospital.domaine.Specialist;
import hospital.domaine.Speciality;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rousseaua on 23/10/15.
 */
public class SpecialistFactory {
    private static SpecialistFactory INSTANCE = new SpecialistFactory();

    public static SpecialistFactory current(){
        return INSTANCE;
    }

    public Set<Specialist> specialists;

    private SpecialistFactory(){
        this.specialists = new HashSet<Specialist>();
    }

    /**
     * @param name the name of the Specialist to return
     * @return the Specialist with the given name, else null
     */
    public Specialist specialistNamed(String name) {
        for(Specialist s : specialists){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    /**
     * Create a Specialist and add it in "specialists"
     *
     * @param name the name to set
     * @param speciality the speciality to set
     */
    public void createSpecialist(String name, Speciality speciality) {
        specialists.add(new Specialist(name, speciality));
    }
}
