package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public abstract class ActionForPerson {

    /*
    *   I am an action that can execute the class with a person.
    *   @param br a BufferedReader if the action need to interact with the user.
    *   @param name The name of the person
     */
    public abstract void action(BufferedReader br, String name) throws IOException;

    /*
    *   I need to print on the console the description of the action.
     */
    public abstract void description();

}
