package fr.univ_lyon1.info.m1.elizagpt.dao;

import fr.univ_lyon1.info.m1.elizagpt.observer.Observable;
import fr.univ_lyon1.info.m1.elizagpt.observer.Observer;
import fr.univ_lyon1.info.m1.elizagpt.dto.ResponseMessagesDto;

import java.util.ArrayList;
import java.util.List;

/**
 * MessageObservable class qui va implementer observable.
 */
public class MessageObservable extends MessageDao implements Observable {
    private List<Observer> observers;

    /**
     * constructeur.
     */
    public MessageObservable() {
        super();
        observers = new ArrayList<>();
    }

    /**
     * ajout d'un observer.
     * @param observer
     */
    @Override
    public void addObserver(final Observer observer) {
        observers.add(observer);
        notifyMyObservers();
    }

    /**
     * notify les observeurs du changement d'etat.
     */
    @Override
    public void notifyMyObservers() {
        for (Observer observer : observers) {
            observer.update(new ResponseMessagesDto(this.getCollection()));
        }
    }

    /**
     * suppression.
     * @param observer
     */
    @Override
    public void removeObserver(final Observer observer) {
         observers.remove(observer);
    }
}
