package WaveSoftProgram;


import org.json.JSONException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class FaultIdentification extends FaultSurvey implements MenuTextOption {

    private static final Logger LOGGER = Logger.getLogger(FaultDiagnosis.class.getName());

    public void faultIdentificationMenu() throws JSONException, IOException {
        boolean quit = false;
        int choice;
        while(!quit){
            printFaultIdentificationMenu();
            Scanner scanner = new Scanner(System.in);
            try {
                //selecting list of options
                Menu menuAutoApp = new Menu();
                choice = scanner.nextInt();
                //clear input buffer
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        constructionProblem();
                        break;
                    case 2:
                        quit = true;
                        break;
                    case 3:
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
                + SECOND_INNER_MENU_THIRD_OPTION + "\n"
                + INSTRUCTION);
    }
}
