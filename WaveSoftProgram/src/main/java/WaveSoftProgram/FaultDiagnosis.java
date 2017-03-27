package WaveSoftProgram;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FaultDiagnosis implements MenuTextOption {

//    private static final Logger ROOT_LOGGER = LogManager.getLogManager().getLogger("");
    private static final Logger LOGGER = Logger.getLogger(FaultDiagnosis.class.getName());

    public void faultDiagnosisMenu() {
        boolean quit = false;
        int choice;
        while(!quit){
            printMenuInstructions();
            LOGGER.info(INSTRUCTION);
            Scanner scanner = new Scanner(System.in);
            try {
                //selecting list of options
                Menu menuAutoApp = new Menu();
                choice = scanner.nextInt();
                //clear input buffer
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        ;
                        break;
                    case 2:
                        ;
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
//                System.out.println(USER_INPUT_FAILURE_NUMBER_TWO);
//              System.err.println("InputMismatchException: " + e.getMessage());
            }
        }
    }

    public void printMenuInstructions() {

    }

//    public void configureRootLogger() {
//        ROOT_LOGGER.setLevel(Level.ALL);
//
//        for (Handler handler : ROOT_LOGGER.getHandlers()) {
//            handler.setLevel(Level.ALL);
//        }
//    }

}
