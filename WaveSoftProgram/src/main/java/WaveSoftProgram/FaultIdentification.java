package WaveSoftProgram;


import org.json.JSONException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class FaultIdentification implements MenuTextOption {

    private static final Logger LOGGER = Logger.getLogger(FaultDiagnosis.class.getName());

    public void faultIdentificationMenu() throws JSONException {
        boolean quit = false;
        int choice;
        while(!quit){
            printFaultIdentificationMenu();
            Scanner scanner = new Scanner(System.in);
            try {
                //selecting list of options
                Menu menuAutoApp = new Menu();
                FaultCatalogMenu faultCatalogMenu = new FaultCatalogMenu();
                choice = scanner.nextInt();
                //clear input buffer
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        /*konstrukcyjne problemy */
                        ;
                        break;
                    case 2:
                        /*Układ mechaniczny-elektryczny */
                        ;
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

    private void printFaultIdentificationMenu() {
        LOGGER.info("\n"
                + SECOND_INNER_MENU_FIRST_OPTION + "\n"
                + SECOND_INNER_MENU_SECOND_OPTION + "\n"
                + THIRD_OPTION + "\n"
                + FOURTH_OPTION + "\n"
                + INSTRUCTION);
    }
}
