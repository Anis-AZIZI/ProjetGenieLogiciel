package fr.univ_lyon1.info.m1.elizagpt.dto;

import fr.univ_lyon1.info.m1.elizagpt.model.Message;

/**
 * Data Transfer Object (DTO) representing a message.
 * This class is used for transferring message data between layers of the application.
 */
public class MessageDto {

    /**
     * Unique identifier for the message.
     */
    private final int id;

    /**
     * Username associated with the message.
     */
    private final String user;

    /**
     * Content of the message.
     */
    private final String message;

    /**
     * Constructor for creating a MessageDto.
     *
     * @param id      The unique identifier for the message.
     * @param user    The username associated with the message.
     * @param message The content of the message.
     */
    public MessageDto(final int id, final String user, final String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }
    /**
     * Constructor for creating a MessageDto.
     *
     * @param message     The unique identifier for the message.
     */
    public MessageDto(final Message message) {
        this.id = message.getId();
        this.user = message.getUser();
        this.message = message.getMessage();
    }
    /**
     * invert from messageDto to message.
     * @return Message
     */
    public Message fromDtoToMessage() {
        return new Message(this.id, this.user, this.message);
    }
    /**
     * Get the unique identifier of the message.
     *
     * @return The unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the username associated with the message.
     *
     * @return The username.
     */
    public String getUser() {
        return user;
    }

    /**
     * Get the content of the message.
     *
     * @return The message content.
     */
    public String getMessage() {
        return message;
    }

}
