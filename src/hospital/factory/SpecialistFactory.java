package hospital.factory;

import hospital.domaine.Specialist;

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

    public Specialist specialistNamed(String name) {
        //TODO
        return null;
    }
}
