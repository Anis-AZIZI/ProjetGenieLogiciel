package fr.univ_lyon1.info.m1.elizagpt.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Logic to process a message (and probably reply to it).
 * Utilise le pattern chaine de responsabilite et pattern strategie.
 */
public class MessageProcessor {
    private List<MessageHandling> handlers;
    private String name;

    /**
     * Constructeur des MessageProcessor.
     */
    public MessageProcessor() {
        // les handlers sotn classes par ordre d'apparition
        // lors une conversation.
        handlers = Arrays.asList(
                new NameHandler(),
                new AskNameHandler(),
                new SuperlativeHandler(),
                new JeSentencesHandler(),
                new QuestionHandler(),
                new GoodByesHandler(),
                new ChatGPTHandler(),
                new RandomQuestions()
        );
    }

    /**
     * Normlize the text: remove extra spaces, add a final dot if missing.
     * 
     * @param text
     * @return normalized text.
     */
    public String normalize(final String text) {
        return text.replaceAll("\\s+", " ")
                .replaceAll("^\\s+", "")
                .replaceAll("\\s+$", "")
                .replaceAll("[^\\.!?:]$", "$0.");
    }



    /**
     * Extract the name of the user from the dialog.
     * 
     * @return The name of the user.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Setter de name.
     * @param name
     */
    protected void setName(final String name) {
        this.name = name;
    }

    /**
     * Extract a matched group from a regular expression.
     * 
     * @param text  The input text.
     * @param regex The regular expression.
     * @return The matched group.
     */
    protected String extractMatchGroup(final String text, final String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null; // Return null if no match is found
        }
    }


    /**
     * Processinput qui utilse le pattern chaine de responsabilite + pattern Strategie.
     * @param input
     * @return
     */
    public String processUserInput(final String input) {
        String normalizedInput = normalize(input);
        for (MessageHandling handler : handlers) {
            String result = handler.handle(normalizedInput, this);
            if (result != null) {
                return result;
            }

        }
        return null; // should be returning random answers
    }
}
