package fr.univ_lyon1.info.m1.elizagpt.observer;

import fr.univ_lyon1.info.m1.elizagpt.dto.ResponseMessagesDto;

/**
 * observer.
 */
public interface Observer {
    //void update(String response);

    /**
     * add changes to our view.
     * @param messages update the view with the new messages.
     */
    void update(ResponseMessagesDto messages);
}
