package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 */
public class PatientAction extends Action {

    protected static final String COMMAND = "actionPatient";

    protected Map<String, String> commands;

    public PatientAction() {
        this.commands = new HashMap<>();
        this.commands.put(Entrance.COMMAND, "hospital.metier.Entrance");
        this.commands.put(RegisterPatient.COMMAND, "hospital.metier.RegisterPatient");
        this.commands.put(Visualisation.COMMAND, "hospital.metier.Visualisation");
        this.commands.put(PatientExit.COMMAND, "hospital.metier.PatientExit");
    }

    /*
    * TODO
     */
    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Nom du patient: ");
        String name = br.readLine();
        System.out.println("Quelle action voulez vous effectuer ?");
        this.generateCommandHelp();
        String command = br.readLine().trim();
        try {
            ActionForPerson action = getInstanceOfClassNamed(command);
            action.action(br, name);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NullPointerException e) {
            //We catch the exceptions for user convenience
            System.out.println("Commande inconnue.");
        }
    }

    //TODO remove code duplication.
    public void generateCommandHelp() {
        for (String command : this.commands.keySet()) {
            System.out.print(command + ": ");
            try {
                ActionForPerson action = getInstanceOfClassNamed(command);
                action.description();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                //Do nothing. This is just help method for user.
            }
        }
    }

    public ActionForPerson getInstanceOfClassNamed(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ActionForPerson) Class.forName(this.commands.get(command)).newInstance();
    }

    public Map<String, String> getCommands() {
        return commands;
    }

    public void setCommands(Map<String, String> commands) {
        this.commands = commands;
    }

    @Override
    public void description() {
        System.out.println("Permet d'effectuer une action sur un patient (enregistrement, sortie, ...)");
    }
}
