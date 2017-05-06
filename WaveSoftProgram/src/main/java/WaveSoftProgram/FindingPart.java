package WaveSoftProgram;

import WaveSoftProgram.parts.Part;
import WaveSoftProgram.parts.PartCategory;
import WaveSoftProgram.parts.PartParser;
import WaveSoftProgram.parts.PlaceInCar;

import java.io.IOException;

/**
 * Class describes how to print an object of a questionnaire for searching a car part on console.
 */
public class FindingPart {

    private PartParser partParser;
    private int placeIndex, categoryIndex, partIndex;

    /**
     * Prints a questionnaire for searching a car part.
     * @param fileName A name of json file which is a source of questions for a questionnaire.
     */
    public void findPartMenu(String fileName) {
        partParser = new PartParser(fileName);

        String stage1 = "miejsce samochodu, gdzie znajduje się zepsuta część:";
        String stage2 = "kategorię części:";
        String stage3 = "szukaną część:";


        printQuestions1(stage1);
        printQuestions2(stage2, placeIndex);
        printQuestions3(stage3, placeIndex, categoryIndex);
        printTip(placeIndex, categoryIndex, partIndex);


    }

    /**
     * Prints a first question in a questionnaire.
     * @param stage A text of a initial question.
     */
    private void printQuestions1(String stage) {
        System.out.println("Wybierz " + stage);
        int i = 1;
        for (PlaceInCar place : partParser.getPlaceInCarList()) {
            System.out.println(i + ". " + place.getNameOfPlace());
            i++;
        }
        placeIndex = readChoice();
    }

    /**
     * Prints a second question in a questionnaire.
     * @param stage A text of a second question.
     * @param placeIndex An index of place with broken car part on the list.
     */
    private void printQuestions2(String stage, int placeIndex) {
        System.out.println("Wybierz " + stage);
        int i = 1;
        for (PartCategory category : partParser.getPlaceInCarList().get(placeIndex).getCategories()) {
            System.out.println(i + ". " + category.getCategoryName());
            i++;
        }
        categoryIndex = readChoice();
    }

    /**
     * Prints a last question in a questionnaire.
     * @param stage A text of a last question.
     * @param placeIndex An index of place with broken car part on the list.
     * @param categoryIndex An index of category of car part on the list.
     */
    private void printQuestions3(String stage, int placeIndex, int categoryIndex) {
        System.out.println("Wybierz " + stage);
        int i = 1;
        for (Part part : partParser.getPlaceInCarList().get(placeIndex).getCategories().get(categoryIndex).getParts()) {
            System.out.println(i + ". " + part.getPartId());
            i++;
        }
        partIndex = readChoice();
    }

    /**
     * Prints a suitable searching phrase.
     * @param placeIndex An index of place with broken car part on the list.
     * @param categoryIndex An index of category of car part on the list.
     * @param partIndex An index a car part on the list.
     */
    private void printTip(int placeIndex, int categoryIndex, int partIndex) {
        System.out.println("Wpisz w wyszukiwarkę: " + partParser.getPlaceInCarList().get(placeIndex).getCategories().get(categoryIndex).getParts().get(partIndex).getSearchPhrase());
        System.out.println("Naciśnij Enter...");
        char ignore;
        try {
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reads an input from a keyboard. An answer chosen by the user.
     * @return An index of a chosen answer on the list.
     */
    private int readChoice() {
        char choice = 0, ignore;
        boolean again = true;
        do {
            try {
                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ((int) choice < '1' | (int) choice > '3')
                System.out.println("Wybierz z dostępnych opcji.");
            else again = false;
        }
        while (again);

        switch (choice) {

            case '1':
                choice = 0;
                break;
            case '2':
                choice = 1;
                break;
            case '3':
                choice = 2;
                break;

        }

        return choice;
    }
}
