package hospital;

import hospital.metier.Interact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by ferlicotdelbe on 23/10/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Interact interaction = (new Interact());
        interaction.setCommandWith(new HashMap<String, String>());
        while (true) {
            interaction.action(br);
        }
    }
}
