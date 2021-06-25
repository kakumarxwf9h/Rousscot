package hospital;

import hospital.metier.Interact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * I am the main of this application. I just launch an interaction with the user.
 * @author Cyril Ferlicot & Aurélien Rousseau
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
