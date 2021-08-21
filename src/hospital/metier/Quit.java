package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am an action that allow the user to quit the application.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class Quit extends Action {

    protected static final String COMMAND = "quitter";

    /**
     *   I quit the application
     * @param br a BufferedReader useless here.
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        br.close();
        System.out.println("Fin de l'application.");
        System.exit(0);
    }

    @Override
    public void description() {
        System.out.println("    Use me to quit the application.");
    }

}
