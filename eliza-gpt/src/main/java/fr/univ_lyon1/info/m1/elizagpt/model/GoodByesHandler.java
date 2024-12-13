package fr.univ_lyon1.info.m1.elizagpt.model;

/**
 * Classe qui prend en charge le message de départ.
 */
public class GoodByesHandler implements MessageHandling {

    /**
     * Prend en charge les différentes façons de dire au revoir.
     *
     * @param message           Le message à traiter.
     * @param messageProcessor Le processeur de message.
     * @return Le message d'aurevoir correspondant, ou null si aucune correspondance n'est trouvée.
     */
    public String handle(final String message, final MessageProcessor messageProcessor) {
        String lowercaseMessage = message.toLowerCase();

        if (lowercaseMessage.contains("au revoir")
                || lowercaseMessage.contains("salem")
                || lowercaseMessage.contains("bye")
                || lowercaseMessage.contains("bye bye")
                || lowercaseMessage.contains("ciao")
                || lowercaseMessage.contains("a plus")
                || lowercaseMessage.contains("a toute")) {
            return "Au revoir!";
        }

        return null;
    }
}

