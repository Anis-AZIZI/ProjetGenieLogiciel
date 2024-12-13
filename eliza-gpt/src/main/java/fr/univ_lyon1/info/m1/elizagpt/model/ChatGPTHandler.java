package fr.univ_lyon1.info.m1.elizagpt.model;

import fr.univ_lyon1.info.m1.elizagpt.util.ChatGPTClient;


/**
 * Handles user messages and interacts with ChatGPT for specific patterns.
 */
public class ChatGPTHandler implements MessageHandling {

    private final ChatGPTClient chatGPTClient;
    private static final String OPENAI_API_KEY = "sk-HW9wIcPrRcPEICQyo5JJ"
            + "T3BlbkFJwP3vvGa3xbZAf4N4a53s";

    /**
     * Constructs a ChatGPTHandler with the specified ChatGPTClient.
     */
    public ChatGPTHandler() {
        this.chatGPTClient = new ChatGPTClient();
    }

    /**
     * Handles the user's message, processing specific
     * patterns and interacting with ChatGPT if needed.
     *
     * @param message           The user's message.
     * @param messageProcessor  The message processor for additional context.
     * @return The response to the user's message.
     */
    @Override
    public String handle(final String message,
                         final MessageProcessor messageProcessor) {
        // Your existing logic for handling specific patterns

        // If the existing logic doesn't handle the message, you can call ChatGPT API
        String chatGPTResponse;
        chatGPTResponse = chatGPTClient.getChatGPTResponse(message);
        return chatGPTResponse;

    }

    /**
     * Extracts the response from the ChatGPT API JSON.
     *
     * @param json The JSON response from the ChatGPT API.
     * @return The extracted response.
     */
    private String extractResponseFromJson(final String json) {
        // Implement logic to extract the response from the JSON
        // For simplicity, let's assume the response is
        // directly in the "choices" field
        // You should adapt this based on the actual response structure from the API
        // This is just a placeholder, and you might need a JSON parsing
        // library for a more robust solution.
        return json.contains("\"choices\":") ? "ChatGPT says: "
                + json.split("\"choices\":")[1]
                .split("\"")[1] : "No valid response from ChatGPT.";
    }
}
