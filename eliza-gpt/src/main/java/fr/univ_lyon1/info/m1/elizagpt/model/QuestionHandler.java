package fr.univ_lyon1.info.m1.elizagpt.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fr.univ_lyon1.info.m1.elizagpt.util.PickRandom;

/**
 * handler of questions.
 */
public class QuestionHandler implements MessageHandling {
    /**
     * handeling of user's questions.
     * @param input entrant.
     * @param processor
     * @return
     */
    @Override
    public String handle(final String input, final MessageProcessor processor) {
        Pattern pattern = Pattern.compile(".*\\?.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(processor.normalize(input));
        if (matcher.matches()) {
            return PickRandom.pickRandom(new String[] {
                    "C'est moi qui pose les questions ici. ",
                    "je crois avoir mal vu, serait-ce une question la ?? ",
                    "je suis questionphobe. ",
                    "Je vous renvoie la question",
                    " Ici, c'est moi qui pose les questions."
            });
        }
        return null;
    }

}

