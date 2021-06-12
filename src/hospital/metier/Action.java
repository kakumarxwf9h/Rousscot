package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by ferlicotdelbe on 23/10/15.
 */
public abstract class Action {

    public abstract void action(BufferedReader br) throws IOException;

}
