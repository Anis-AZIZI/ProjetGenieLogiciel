package fr.univ_lyon1.info.m1.elizagpt.model;

import java.io.IOException;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ_lyon1.info.m1.elizagpt.ressources.VerbesConjug;
import fr.univ_lyon1.info.m1.elizagpt.util.PickRandom;

/**
 * gere les requetes du style "quel est mon nom?".
 */
public class JeSentencesHandler implements MessageHandling {

    private Map<String, String> verbConjugations;

    /**
     * Constructs a new instance of JeSentenceHandler and loads verb conjugations from a JSON file.
     */
    public JeSentencesHandler() {
        loadVerbConjugations();
    }
    /**
     * Loads verb conjugations from a JSON file and populates the verbConjugations map.
     */
    private void loadVerbConjugations() {
        // Get file from resources folder

        try {
                // Create ObjectMapper instance
                ObjectMapper objectMapper = new ObjectMapper();

                // Read JSON file into JsonNode
                JsonNode jsonNode = objectMapper.readTree(new File("./src/main/ressources"
                        + "/static/output.json"));

            if (jsonNode != null) {

                 verbConjugations = new HashMap<>();

                // Iterate over the fields of the JSON object
                Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    String verb = entry.getKey();
                    String conjugation = entry.getValue().asText();
                    verbConjugations.put(verb, conjugation);
                }

            } else {
                // Handle the case where the resource is not found
                System.err.println("Resource not found: output.json");
                verbConjugations = VerbesConjug.getVerbsConjug();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log, throw a specific exception, etc.)
            verbConjugations = VerbesConjug.getVerbsConjug();
        }
    }

    /**
     * le handler.
     *
     * @param message
     * @return String
     */
    public String handle(final String message, final MessageProcessor messageProcessor) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile("(Je .*)\\.", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(message);
        if (matcher.matches()) {
            final String startQuestion = PickRandom.pickRandom(new String[] {
                    "Pourquoi dites-vous que ",
                    "Pourquoi pensez-vous que ",
                    "Êtes-vous sûr que "
            });
            return startQuestion + firstToSecondPerson(matcher.group(1)) + " ?";
        }
        return null;
    }
    /**
     * Transforms a first-person sentence into second-person form using verb conjugations.
     *
     * @param sentence  The first-person sentence.
     * @return The sentence in second-person form.
     */
    private String firstToSecondPerson2(final String sentence) {
        String newSentence = null;
        // Example implementation using verb conjugations map
        for (Map.Entry<String, String> entry : verbConjugations.entrySet()) {
            String firstPersonSingular = entry.getKey();
            String secondPersonPlural = entry.getValue();
            newSentence = sentence.replaceAll("\\b"
                    + firstPersonSingular + "\\b", secondPersonPlural);
        }
        return newSentence;
    }
    /**
     * Transforms a first-person sentence into second-person form using verb conjugations.
     *
     * @param sentence  The first-person sentence.
     * @return The sentence in second-person form.
     */
    public String firstToSecondPerson(final String sentence) {
        // Split the sentence into words
        String[] words = sentence.split("\\s+");

        // Iterate over each word
        for (int i = 0; i < words.length; i++) {
            // Remove punctuation from the word
            String word = words[i].replaceAll("[^a-zA-Z]", "");

            // Check if the word is in the verbConjugations map
            if (verbConjugations.containsKey(word)) {
                // Replace the word with its corresponding value
                words[i] = verbConjugations.get(word);
            }
        }

        // Join the words back into a sentence
        return String.join(" ", words)
                .replaceAll("[Jj]e ([a-z]*)s ", "vous $1ssez ")
                .replace("je ", "vous ")
                .replace("mon ", "votre ")
                .replace("ma ", "votre ")
                .replace("mes ", "vos ")
                .replace("moi", "vous");
    }

}
