package fr.univ_lyon1.info.m1.elizagpt.controler;

import fr.univ_lyon1.info.m1.elizagpt.dao.MessageObservable;
import fr.univ_lyon1.info.m1.elizagpt.dto.ResponseMessagesDto;
import fr.univ_lyon1.info.m1.elizagpt.model.Message;
import fr.univ_lyon1.info.m1.elizagpt.model.MessageProcessor;

import java.util.List;

/**
 * Main class of the Controler of the App.
 */
public class Controler {
    private MessageProcessor model;

    private MessageObservable messages;
    /**
     * Create the Controler.
     *
     */
    public Controler() {
        this.messages = new MessageObservable();
        this.model = new MessageProcessor();

    }

    /**
     * Search function.
     * 
     * @param searchText
     */
    public ResponseMessagesDto search(final String searchText, final String searchOption) {
        List<Message> resulatedMessages;
        switch (searchOption) {
            case "Search by Substring":
                resulatedMessages = messages.searchBySubString(searchText);
                break;
            default:
                resulatedMessages = messages.searchByRegex(searchText);
                break;
        }
        ResponseMessagesDto responseMessagesDto = new ResponseMessagesDto(resulatedMessages);
        messages.notifyMyObservers();
        return responseMessagesDto;
    }

    /**
     * recois l'input de l'utilisateur transmis par la vue et l'integre aux messges.
     * @param message
     */
    public void incomingMessage(final String message) {
        messages.add(new Message("user", message));
        generateAnswer(message);
        messages.notifyMyObservers();
    }
    /**
     * Delete request.
     * @param id a delete.
     */
    public void deleteThisMessage(final int id) {
        if (messages.deleteMessageById(id)) {
            messages.notifyMyObservers();
        }
    }

    /**
     * apres la reception du message utilisateur generer une reponse par l'Ia.
     *
     */
    public void generateAnswer(final String lastMessage) {
        String answer = model.processUserInput(lastMessage);
        messages.add(new Message("Eliza", answer));

    }
    /**
     * rend les messages.
     * @return messages
     */
    public MessageObservable getMessages() {
      return this.messages;
    };
    /**
     * Refrsh .
     *
     */
    public void refresh() {
        messages.notifyMyObservers();
    }
}

