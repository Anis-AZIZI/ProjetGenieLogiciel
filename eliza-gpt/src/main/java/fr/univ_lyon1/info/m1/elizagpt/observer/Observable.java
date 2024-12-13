package fr.univ_lyon1.info.m1.elizagpt.observer;

/**
 * observable.
 */
public interface Observable {

    /**
     * Ajouter un observer a la liste d'observers.
     * @param observer objet observer.
     */
    void addObserver(Observer observer);

    /**
     * function qui notifie les observers qu'un evenement "event" s'est produit.
     */
    void notifyMyObservers();
    /**
     * function qui supprime un observer de la liste.
     * @param observer objet observer.
     */
    void removeObserver(Observer observer);

}
