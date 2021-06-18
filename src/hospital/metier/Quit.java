package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by ferlicotdelbe on 23/10/15.
 */
public class Quit extends Action {

    protected static final String COMMAND = "quit";

    public void action(BufferedReader br) throws IOException {
        br.close();
        System.out.print("Fin de l'application.");
        System.exit(0);
    }

    public void description(){
        System.out.println("    Use me to quit the application.");
    }

}
