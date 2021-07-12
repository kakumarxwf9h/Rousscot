package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class Consultation extends Action {

    protected final static String COMMAND = "consultation";

    /*
    * TODO
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        //TODO
    }

    @Override
    public void description() {
        System.out.println("Permet d'effectuer une consultation.");
    }
}
