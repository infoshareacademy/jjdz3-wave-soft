package WaveSoftProgram;

import org.json.JSONException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class FaultCatalogMenu extends JsonHandling implements MenuTextOption {

    private static final Logger LOGGER = Logger.getLogger(FaultDiagnosis.class.getName());

    public void faultDiagnosisMenu() throws JSONException {
        boolean quit = false;
        int choice;
        while(!quit){
            printFaultCatalogMenuInstructions();
            Scanner scanner = new Scanner(System.in);
            try {
                //selecting list of options
                Menu menuAutoApp = new Menu();
                FaultDiagnosis backMenu = new FaultDiagnosis();
                choice = scanner.nextInt();
                //clear input buffer
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        iteratingJSON();
                        break;
                    case 2:
                        searchCertainFault();
                        break;
                    case 3:
                        quit = true;
                        break;
                    case 4:
                        menuAutoApp.progEnding();
                        quit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                    LOGGER.info(ERROR);
            }
        }
    }

    private void printFaultCatalogMenuInstructions() {
        LOGGER.info("\n"
                + INNER_MENU_FIRST_OPTION + "\n"
                + INNER_MENU_SECOND_OPTION + "\n"
                + THIRD_OPTION + "\n"
                + FOURTH_OPTION + "\n"
                + INSTRUCTION);
    }
}
