package fr.univ_lyon1.info.m1.elizagpt.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class qui prend en charge le message contenant le nom.
 */
public class NameHandler implements MessageHandling {

    /**
     * prise ne charge des phrases je m'appelle.
     * @param message
     * @return String
    */
    public String handle(final String message, final MessageProcessor messageProcessor) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(".*Je m'appelle (.*)\\.", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(message);
        if (matcher.matches()) {
            // ajouter le nom dans la variable name du message processor.
            messageProcessor.setName(matcher.group(1));
            return "Bonjour " + matcher.group(1) + ".";
        }
        return null;
    }

}
