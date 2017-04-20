package WaveSoftProgram;

import org.json.JSONException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class FaultDiagnosis extends JsonHandling implements MenuTextOption {

    private static final Logger LOGGER = Logger.getLogger(FaultDiagnosis.class.getName());

    public void faultDiagnosisMenu() throws JSONException, IOException {
        boolean quit = false;
        int choice;
        while(!quit){
            printMenuInstructions();
            Scanner scanner = new Scanner(System.in);
            try {
                //selecting list of options
                Menu menuAutoApp = new Menu();
                FaultCatalogMenu faultCatalogMenu = new FaultCatalogMenu();
                FaultIdentification faultIdentification = new FaultIdentification();
                choice = scanner.nextInt();
                //clear input buffer
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        faultCatalogMenu.faultDiagnosisMenu();
                        break;
                    case 2:
                        faultIdentification.faultIdentificationMenu();
                        break;
                    case 3:
                        menuAutoApp.showMenu();
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

    public void printMenuInstructions() {
        LOGGER.info("\n"
                    + FIRST_OPTION + "\n"
                    + SECOND_OPTION + "\n"
                    + BACK_TO_MAIN_MENU + "\n"
                    + EXIT + "\n"
                    + INSTRUCTION);
    }
}
