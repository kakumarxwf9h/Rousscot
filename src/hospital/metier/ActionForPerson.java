package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am an abstract class that manage the actions of a person.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public abstract class ActionForPerson {

    /**
     * I am an action that can execute the class with a person.
     *
     * @param br   a BufferedReader if the action need to interact with the user.
     * @param name The name of the person
     * @throws IOException
     */
    public abstract void action(BufferedReader br, String name) throws IOException;


    /**
     * I return a description for an action.
     * @return a description of the action.
     */
    public abstract String description();

}
