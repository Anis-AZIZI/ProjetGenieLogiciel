package fr.univ_lyon1.info.m1.elizagpt.dao;

import fr.univ_lyon1.info.m1.elizagpt.model.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * constructeur.
 */
public class MessageDao extends AbstractListDao<Message> {

    /**
     * initialsation de notre liste MessageDao.
     */
    public MessageDao() {
        super();
        this.addMessage("Eliza", "Bonjour");
    }
    /**
     * function qui va gere les ajouts de messages.
     * @param user
     * @param message
     */
    private void addMessage(final String user, final String message) {
        this.add(new Message(user, message));
    }

    /**
     * function that get last message from Dao.
     * @return meessage
     */
    public  String getLastMessage() {
        if (this.getCollection().isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        // Get the last element using the size of the list
        return this.getCollection().get(this.getCollection().size() - 1).getMessage();
    }
    /**
     * Removes a message with the specified ID from the list of messages.
     *
     * @param messageId The ID of the message to be deleted.
     * @return true if the message with the given ID was found and removed, false otherwise.
     */
    public boolean deleteMessageById(final int messageId) {
        Iterator<Message> iterator = this.getCollection().iterator();

        while (iterator.hasNext()) {
            Message message = iterator.next();

            if (message.getId() == messageId) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    /**
     * Search function.
     * @param searchText
     */
    public List<Message> searchBySubString(final String searchText) {
        List<Message> result = new ArrayList<>();

        for (Message message : this.getCollection()) {
            if (message.getMessage().contains(searchText)) {
                result.add(message);
            }
        }
        return result;
    }
    /**
     * Search function by regex.
     * @param searchText
     * @return result Message
     */
    public List<Message> searchByRegex(final String searchText) {
        List<Message> result = new ArrayList<>();

        for (Message message : this.getCollection()) {
            if (message.getMessage().matches(searchText)) {
                result.add(message);
            }
        }
        return result;
    }
}
