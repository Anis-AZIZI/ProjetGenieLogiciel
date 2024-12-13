package fr.univ_lyon1.info.m1.elizagpt.util;

//import org.junit.jupiter.api.Test;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

/**
 * Tests for ChatGPTClient.
 */
public class ChatGPTClientTest {
    //les tests ne passent pas sur la vm a caude de restrictions
    // sur l'accès a internet sur la CD/CI de github.
    // decommenter cette partie lors des tests en local.

    /*
    /**
     * Test the message processor.
     *//*
    @Test
    public void testChatGPTClient() {
        ChatGPTClient chatGPTClient = new ChatGPTClient();
        assertThat(chatGPTClient.getChatGPTResponse("Bonjour"), is(notNullValue()));
    }

    /**
     * Test si le prompt S'identifie a Eliza Gpt.
     *//*
    @Test
    public void testChatGPTClientPrompt() {
        ChatGPTClient chatGPTClient = new ChatGPTClient();
        assertThat(chatGPTClient.getChatGPTResponse("Eliza"), containsString("Eliza"));
    }
    */
}
