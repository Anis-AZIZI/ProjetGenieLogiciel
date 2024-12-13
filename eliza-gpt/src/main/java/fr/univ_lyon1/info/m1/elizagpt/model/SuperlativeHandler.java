package fr.univ_lyon1.info.m1.elizagpt.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * gere les requetes du style "qui est le plus XX ?".
 */
public class SuperlativeHandler implements MessageHandling {

    /**
     * le handler.
     * @param message
     * @return String
     */
    public String handle(final String message, final MessageProcessor messageProcessor) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile("Qui est le plus (.*) \\?", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(message);
        if (matcher.matches()) {
            return "Le plus " + matcher.group(1)
                    + " est bien sûr votre enseignant de MIF01 !";
        }
        return null;
    }
}
