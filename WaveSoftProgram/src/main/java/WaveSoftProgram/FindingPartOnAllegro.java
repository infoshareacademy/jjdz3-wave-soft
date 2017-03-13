package WaveSoftProgram;

import WaveSoftProgram.parts.Part;
import WaveSoftProgram.parts.PartCategory;
import WaveSoftProgram.parts.PartParser;
import WaveSoftProgram.parts.PlaceInCar;

import java.io.IOException;

/**
 * Created by piotr_gy on 01.03.17.
 */
public class FindingPartOnAllegro {

    private PartParser partParser;
    private int placeIndex, categoryIndex, partIndex;

    public void findPartMenu() {
        partParser = new PartParser();

        String stage1 = "miejsce samochodu, gdzie znajduje się zepsuta część:";
        String stage2 = "kategorię części:";
        String stage3 = "szukaną część:";


        printQuestions1(stage1);
        printQuestions2(stage2, placeIndex);
        printQuestions3(stage3, placeIndex, categoryIndex);
        printTip(placeIndex, categoryIndex, partIndex);


    }

    private void printQuestions1(String stage) {
        System.out.println("Wybierz " + stage);
        int i = 1;
        for (PlaceInCar place : partParser.getPlaceInCarList()) {
            System.out.println(i + ". " + place.getNameOfPlace());
            i++;
        }
        placeIndex = readChoice();
    }

    private void printQuestions2(String stage, int placeIndex) {
        System.out.println("Wybierz " + stage);
        int i = 1;
        for (PartCategory category : partParser.getPlaceInCarList().get(placeIndex).getCategories()) {
            System.out.println(i + ". " + category.getCategoryName());
            i++;
        }
        categoryIndex = readChoice();
    }

    private void printQuestions3(String stage, int placeIndex, int categoryIndex) {
        System.out.println("Wybierz " + stage);
        int i = 1;
        for (Part part : partParser.getPlaceInCarList().get(placeIndex).getCategories().get(categoryIndex).getParts()) {
            System.out.println(i + ". " + part.getPartId());
            i++;
        }
        partIndex = readChoice();
    }

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


    private int readChoice() {
        char choice = 0, ignore;
        try {
            choice = (char) System.in.read();
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
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