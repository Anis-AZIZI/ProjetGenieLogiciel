package fr.univ_lyon1.info.m1.elizagpt.model;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Tests for Message.
 */
public class MessageTest {
    /**
     * Test the message.
     */
    @Test
    public void testMessage() {
        Message message = new Message("user", "message");
        assertThat(message.getUser(), is("user"));
        assertThat(message.getMessage(), is("message"));
    }
}
