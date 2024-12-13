package fr.univ_lyon1.info.m1.elizagpt.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests for MessageProcessor.
 */
public class MessageProcessorTest {
    /**
     * Test the message processor.
     */
    @Test
    public void testMessageProcessor() {
        MessageProcessor messageProcessor = new MessageProcessor();
        assertThat(messageProcessor.getName(), is(nullValue()));
        assertThat(messageProcessor.processUserInput("Je m'appelle Jean."),
                is("Bonjour Jean."));
        assertThat(messageProcessor.getName(), is("Jean"));
        assertThat(messageProcessor.processUserInput("Quel est mon nom ?"),
                is("Votre nom est Jean."));
        assertThat(messageProcessor.processUserInput("Quel est mon nom ?"),
                is("Votre nom est Jean."));
        assertThat(messageProcessor.processUserInput("Au revoir."), is("Au revoir!"));
    }

}
