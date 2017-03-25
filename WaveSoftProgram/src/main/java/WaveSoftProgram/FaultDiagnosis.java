package WaveSoftProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FaultDiagnosis {

    private String FIRST_OPTION = "Katalog awarii";
    private String SECOND_OPTION = "Identyfikacja awarii";
    private String THIRD_OPTION = "Wyjdź do głównego menu - wciśnij 3";
    private String FOURTH_OPTION = "zakończ program - wciśnij 4";
    private String INSTRUCTION = "Co wybierasz?";

    public void faultDiagnosisMenu() {
        boolean quit = false;
        int choice;
        while(!quit){
            printMenuInstructions();
//            System.out.println(QUESTION_FOR_USER);
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
