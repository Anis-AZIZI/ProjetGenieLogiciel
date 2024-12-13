package fr.univ_lyon1.info.m1.elizagpt.model;

/**
 * Model de message qui contiendra un User et un message à sauvegarder.
 */
public class Message {

    /**
     * Unique identifier for the message.
     */
    private static int nextId = 1; // Static counter for generating incremental IDs

    /**
     * Unique identifier for the message.
     */
    private final int id;

    /**
     * Username.
     */
    private final String user;

    /**
     * Le message à sauvegarder.
     */
    private final String message;

    /**
     * Constructeur.
     *
     * @param user    The username.
     * @param message The message to save.
     */
    public Message(final String user, final String message) {
        this.id = nextId++;
        this.user = user;
        this.message = message;
    }
    /**
     * Constructeur utiliser par le Messagedto pour recree le message.
     * @param id
     * @param user    The username.
     * @param message The message to save.
     */
    public Message(final int id, final String user, final String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    /**
     * Get method for the message field.
     *
     * @return The message.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Get method for the user field.
     *
     * @return The username.
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Get method for the unique identifier of the message.
     *
     * @return The unique identifier.
     */
    public int getId() {
        return this.id;
    }
}
