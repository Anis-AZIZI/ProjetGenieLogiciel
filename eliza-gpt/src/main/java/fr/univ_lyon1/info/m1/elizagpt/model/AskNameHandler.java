package fr.univ_lyon1.info.m1.elizagpt.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *gere les requetes du style "quel est mon nom?".
 */
public class AskNameHandler implements MessageHandling {

    /**
     * le handler.
     * @param message
     * @return String
     */
    public String handle(final String message, final MessageProcessor messageProcessor) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile("Quel est mon nom \\?", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(message);
        if (matcher.matches()) {
            if (messageProcessor.getName() != null) {
                return "Votre nom est " + messageProcessor.getName() + ".";
            } else {
                return "Je ne connais pas votre nom.";
            }
        }
        return  null;
    }
}
