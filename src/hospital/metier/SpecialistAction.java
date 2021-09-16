package hospital.metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * I am a class to manage a Specialist actions.
 *
 * @author Cyril Ferlicot & Aurélien Rousseau
 */
public class SpecialistAction extends Action {

    protected static final String COMMAND = "actionSpecialiste";


    public SpecialistAction() {
        this.commands = new HashMap<>();
        this.commands.put(RegisterSpecialist.COMMAND, "hospital.metier.RegisterSpecialist");
        this.commands.put(Consultation.COMMAND, "hospital.metier.Consultation");
    }

    @Override
    public void action(BufferedReader br) throws IOException {
        System.out.println("Nom du Spécialiste: ");
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
                System.out.println(action.description());
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                //Do nothing. This is just help method for user.
            }
        }
    }

    public ActionForPerson getInstanceOfClassNamed(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ActionForPerson) Class.forName(this.commands.get(command)).newInstance();
    }

    @Override
    public String description() {
        return "Permet d'effectuer une action avec un spécialiste (enregistrement, consultation, ...)";
    }
}
