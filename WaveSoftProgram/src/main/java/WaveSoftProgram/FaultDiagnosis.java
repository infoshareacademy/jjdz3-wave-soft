package WaveSoftProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FaultDiagnosis implements MenuTextOption {

    public void faultDiagnosisMenu() {
        boolean quit = false;
        int choice;
        while(!quit){
            printMenuInstructions();
            System.out.println(INSTRUCTION);
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

}
