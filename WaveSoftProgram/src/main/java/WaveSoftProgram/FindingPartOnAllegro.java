package WaveSoftProgram;

import WaveSoftProgram.parts.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by piotr_gy on 01.03.17.
 */
public class FindingPartOnAllegro {

    private PartParser partParser;

    public void findPartMenu(){
        partParser = new PartParser();
        int index = 1;
        String stage1 = "miejsce samochodu, gdzie znajduje się zepsuta część:";
        String stage2 = "kategorię części:";
        String stage3 = "szukaną część:";

        /*System.out.println("Wybierz "+stage1);
        int i=1;
        for (PlaceInCar place: partParser.getPlaceInCarList()) {
            System.out.println(i+". "+place.getNameOfPlace());
            i++;
        }*/
        printQuestions1(stage1);

        char choice = 0;
        try {
            choice = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice) {

            case '1':
                printQuestions2(stage2, 0);

                break;}


    }

    private void printQuestions1(String stage){
        System.out.println("Wybierz "+stage);
        int i=1;
        for (PlaceInCar place: partParser.getPlaceInCarList()) {
            System.out.println(i+". "+place.getNameOfPlace());
            i++;}
    }

    private void printQuestions2(String stage, int index){
        System.out.println("Wybierz "+stage);
        int i=1;
        for (PartCategory category: partParser.getPlaceInCarList().get(index).getCategories()) {
            System.out.println(i+". "+category.getCategoryName());
            i++;}
    }
}
