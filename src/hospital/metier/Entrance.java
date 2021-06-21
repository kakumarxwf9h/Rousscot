package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by JeCisC on 25/10/2015.
 */
public class Entrance extends Action {

    protected final static String COMMAND = "entrance";

    @Override
    public void action(BufferedReader br) throws IOException {
        //TODO
    }

    @Override
    public void description() {
        System.out.println("Permet d'enregistrer l'entrée d'un patient.");
    }
}
