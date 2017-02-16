package WaveSoftProgram;


import org.json.JSONException;

public class App
{
    public static void main( String[] args )
            throws java.io.IOException, JSONException {
        char choice, ignore;
        Menu menuAutoApp = new Menu();
        menuAutoApp.showLogo();
        menuAutoApp.showMenu();


        for(;;) {

            do {

                choice = (char) System.in.read();

                do { ignore = (char) System.in.read();
                } while(ignore != '\n');

            } while( !menuAutoApp.isValid(choice));

                    if(choice == 'q') {

                        menuAutoApp.progEnding();

                        break;
                    } else if(choice == 'z') {

                        menuAutoApp.showMenu();

                    }

                menuAutoApp.menuLogic(choice);


        }
    }
}

