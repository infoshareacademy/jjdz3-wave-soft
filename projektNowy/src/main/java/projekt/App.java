package projekt;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class App {
    public static void main(String args[]) throws IOException {


        App KwestionariuszWaveSoft = new App();
        Menu newMenu = new Menu();


        Scanner scan = new Scanner(System.in);
        newMenu.showMenu();



        try {
            Kwestionariusz kwestionariusz = new Kwestionariusz();
            kwestionariusz.setPytanie("Jak często Pan/Pani bierze udział w różnych grach?");
            kwestionariusz.setOdpowiedzi("A. Codziennie \n" +  "B. Raz w tygodniu \n" + "C. Raz w miesiącu \n");
            KwestionariuszWaveSoft.writeJSON(kwestionariusz);



            Kwestionariusz kwestionariuszDwa = new Kwestionariusz();
            kwestionariuszDwa.setPytanie("Jaki rodzaj gier Pan/Pani lubi najbardziej?");
            kwestionariuszDwa.setOdpowiedzi("A. Komputerowe \n" +  "B. Planszowe \n" + "C. Karciane \n");
            KwestionariuszWaveSoft.writeJSON2(kwestionariuszDwa);



            Kwestionariusz kwestionariuszTrzy = new Kwestionariusz();
            kwestionariuszTrzy.setPytanie("Komputer czy konsola?");
            kwestionariuszTrzy.setOdpowiedzi("A. Komputer \n" +  "B. Konsola \n" + "C. Nic \n");
            KwestionariuszWaveSoft.writeJSON3(kwestionariuszTrzy);




        }


        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }



        for(;;) {

            String in;

            in = scan.nextLine();

            if (in.equals("1")) {

                Kwestionariusz pytanie1 = KwestionariuszWaveSoft.readJSON();
                System.out.println(pytanie1);

            } else if (in.equals("A") | in.equals("B") | in.equals("C")) {
                Kwestionariusz pytanie2 = KwestionariuszWaveSoft.readJSON2();
                System.out.println(pytanie2);

                break;

            } else if (in.equals("q")) {
                System.out.println("");
                System.out.println("Zakończono...\n");
                System.out.println("-----------------------------------------------------");
            break;
            }

        }


        for(;;) {

            String in;

            in = scan.nextLine();



            if (in.equals("A") | in.equals("B") | in.equals("C")) {

                Kwestionariusz pytanie3 = KwestionariuszWaveSoft.readJSON3();
                System.out.println(pytanie3);
                break;

            } else if (in.equals("q")) {
                System.out.println("");
                System.out.println("Zakończono...\n");
                System.out.println("-----------------------------------------------------");
                break;
            }


        }

        for(;;) {

            String in;

            in = scan.nextLine();



            if (in.equals("A") | in.equals("B") | in.equals("C")) {

                System.out.println("-----------------------------------------------------");
                System.out.println("");
                System.out.println("Dziękujemy za wzięcie udziału w kwestionariuszu.");
                break;

            } else if (in.equals("q")) {
                System.out.println("");
                System.out.println("Zakończono...\n");
                System.out.println("-----------------------------------------------------");

                break;
            }


        }






    }

    private void writeJSON(Kwestionariusz kwestionariusz) throws JsonGenerationException,  JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("pytanie.json"), kwestionariusz);
    }

    private Kwestionariusz readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Kwestionariusz kwestionariusz = mapper.readValue(new File("pytanie.json"), Kwestionariusz.class);
        return kwestionariusz;
    }
    private void writeJSON2(Kwestionariusz kwestionariusz) throws JsonGenerationException,  JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("pytanie2.json"), kwestionariusz);
    }

    private Kwestionariusz readJSON2() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Kwestionariusz kwestionariusz = mapper.readValue(new File("pytanie2.json"), Kwestionariusz.class);
        return kwestionariusz;
    }

    private void writeJSON3(Kwestionariusz kwestionariusz) throws JsonGenerationException,  JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("pytanie3.json"), kwestionariusz);
    }

    private Kwestionariusz readJSON3() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Kwestionariusz kwestionariusz = mapper.readValue(new File("pytanie3.json"), Kwestionariusz.class);
        return kwestionariusz;
    }



}

class Kwestionariusz {
    private String pytanie;
    private String odpowiedzi;



    public Kwestionariusz(){}

    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public String getOdpowiedzi() {
        return odpowiedzi;
    }

    public void setOdpowiedzi(String odpowiedzi) {
        this.odpowiedzi = odpowiedzi;
    }

    public String toString() {
        return  pytanie + "\n " + "\n" + odpowiedzi;

    }

}

class Menu {

    void showMenu() {
        System.out.println("----------------------------------------------------- \n");
        System.out.println("Zachęcamy do wypełnienia krótkiego kwestionariusza.\n");
        System.out.println(" 1. Kliknij 1 a potem ENTER aby rozpocząć ankietę. \n");
        System.out.println(" Wybierz numer instrukcji lub q aby zakończyć.  \n");

    }


}