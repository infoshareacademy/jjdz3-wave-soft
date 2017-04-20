package WaveSoftProgram;

import org.json.JSONException;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class FaultSurvey extends JsonHandling implements MenuTextOption {

    private static final Logger LOGGER = Logger.getLogger(FaultDiagnosis.class.getName());
    static String inputValidator;
    static HashSet<String> answerValues = new HashSet<String>();
    static Map<String, String> questions = new HashMap<String, String>();

    public static void constructionProblem() throws JSONException, IOException {

        creatingMap();
        failureSurvey(questions);
        searchingJsonByHashSetFailure(answerValues);
    }

    public static void creatingMap() {
        questions.put(FALIURE_QUESTION_OIL_PRESSURE, "mechanical");
        questions.put(FAILURE_QUESTION_BATTERY_CHARGE, "electric");
        questions.put(FALIURE_QUESTION_HIGH_TEMPERATURE, "mechanical");
        questions.put(FAILURE_QUESTION_STEERING_WHEEL, "mechanical");
        questions.put(FAILURE_QUESTION_ENGINE, "mechanical");
    }

    public static void failureSurvey(Map<String, String> map) {
        LOGGER.info(FAILURE_SURVEY_START);
        for(Map.Entry<String, String> entry: map.entrySet()) {
            LOGGER.info(entry.getKey());
            Scanner scanner = new Scanner(System.in);
            scannerValidator(scanner);
            inputValidator = scanner.next();
            String questionValidatorToLower = inputValidator.toLowerCase();
            if (questionValidatorToLower.equals("t")) {
                answerValues.add(String.valueOf(entry.getValue()));
            }
        }
    }

    public static Scanner scannerValidator(Scanner givenInput) {
        while (!givenInput.hasNext("[tn]")) {
            LOGGER.info(ERROR);
            givenInput.next();
        }
        return givenInput;
    }
}
