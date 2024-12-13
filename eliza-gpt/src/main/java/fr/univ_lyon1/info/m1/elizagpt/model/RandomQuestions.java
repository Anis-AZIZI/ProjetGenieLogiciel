package fr.univ_lyon1.info.m1.elizagpt.model;

import fr.univ_lyon1.info.m1.elizagpt.util.PickRandom;

/**
 * Pick random answers if all the handlers failed to handle.
 */
public class RandomQuestions implements MessageHandling {

    @Override
    public String handle(final String message, final MessageProcessor messageProcessor) {
        String name = messageProcessor.getName();

// Check if the name is not null
        if (name != null) {
            return PickRandom.pickRandom(new String[]{
                    "Il fait beau aujourd'hui, vous ne trouvez pas ?",
                    "Je ne comprends pas.",
                    "Hmmm, hmm ...",
                    "Qu'est-ce qui vous fait dire cela, " + name + " ?"
            });
        } else {
            return PickRandom.pickRandom(new String[]{
                    "Il fait beau aujourd'hui, vous ne trouvez pas ?",
                    "Je ne comprends pas.",
                    "Hmmm, hmm ...",
            });
        }
    }
}
