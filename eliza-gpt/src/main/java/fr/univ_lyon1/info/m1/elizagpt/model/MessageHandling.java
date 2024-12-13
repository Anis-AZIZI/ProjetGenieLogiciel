package fr.univ_lyon1.info.m1.elizagpt.model;

/**
 * Classe qui implementera le patten Strategie.
 */
public interface MessageHandling {
    /**
     * Recherche fonction qui servira a etablir un pattern Strategie.
     * @param message entrant.
     * @param messageProcessor
     * @return String reponse.
     */
    String handle(String message, MessageProcessor messageProcessor);
}
