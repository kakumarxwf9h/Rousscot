package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * I begin an interaction with the user. When an action end, I am call to launch a new action.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class Interact extends Action {

    /**
     * I am the action of this class.
     * I display to the user the commands he can use then I launch the action he selected.
     *
     * @param br a BufferedReader if the action need to interact with the user.
     * @throws IOException
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Bonjour, quelle action voulez vous effectuer ?");
        this.generateCommandHelp();
        String command = br.readLine().trim();
        try {
            Action action = getInstanceOfClassNamed(command);
            action.action(br);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NullPointerException e) {
            //We catch the exceptions for user convenience
            System.out.println("Mauvaise commande.");
            this.action(br);
        }
    }


    /**
     * I generate an help to the user.
     */
    public void generateCommandHelp() {
        for (String command : this.commands.keySet()) {
            System.out.print(command + ": ");
            try {
                Action action = getInstanceOfClassNamed(command);
                System.out.println(action.description());
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                //Do nothing. This is just help method for user.
            }
        }
        System.out.println();
    }


    /**
     * I take the name of a command and I return a new instance of the corresponding class from the commands map.
     *
     * @param command the command corresponding of the class
     * @return An instance of an action class.
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public Action getInstanceOfClassNamed(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Action) Class.forName(this.commands.get(command.toLowerCase())).newInstance();
    }

    /**
     * I generate the basic commands of the application.
     * I take an existing Map to let someone extend this application.
     * If someone need more command he can initialize the Map with the new commands then I will add the basic commands of the application.
     * A switch case would not have allow that :(
     *
     * @param map I take a map with a command as key and a class name as value.
     */
    public void setCommandWith(Map<String, String> map) {
        map.put(PatientAction.COMMAND.toLowerCase(), "hospital.metier.PatientAction");
        map.put(SpecialistAction.COMMAND.toLowerCase(), "hospital.metier.SpecialistAction");
        map.put(ListPatient.COMMAND.toLowerCase(), "hospital.metier.ListPatient");
        map.put(ListSpecialist.COMMAND.toLowerCase(), "hospital.metier.ListSpecialist");
        map.put(Quit.COMMAND.toLowerCase(), "hospital.metier.Quit");
        this.commands = map;
    }

    @Override
    public String description() {
        //do nothing for this class
        return null;
    }
}
