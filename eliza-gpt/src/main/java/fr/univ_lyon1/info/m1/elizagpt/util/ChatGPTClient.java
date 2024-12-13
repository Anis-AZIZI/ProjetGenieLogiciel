package fr.univ_lyon1.info.m1.elizagpt.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Client for the OpenAI Chat API.
 */
public class ChatGPTClient {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "sk-HW9wIcPrRcPEICQyo5JJ"
            + "T3BlbkFJwP3vvGa3xbZAf4N4a53s";
    private static final String MODEL_NAME = "gpt-3.5-turbo";

    /**
     * Gets the response from the ChatGPT API.
     *
     * @param message The user's message.
     * @return The response from the ChatGPT API.
     */
    public String getChatGPTResponse(final String message) {
        try {
            // Set up the HTTP connection
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setDoOutput(true);

            // Prepare the request payload
            String payload = "{\"model\": \"" + MODEL_NAME + "\","
                     + " \"messages\": [{\"role\": \"system\", \"content\":"
                    + " \"You are a helpful french assistant named Eliza-gpt.\"},"
                    + " {\"role\": \"user\","
                    + " \"content\": \"" + message + "\"}]}";

            // Send the request
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                wr.write(input, 0, input.length);
            }

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get the response
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(),
                                StandardCharsets.UTF_8))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    return extractContentFromResponse(response.toString());
                }
            } else {
                // Read from the error stream
                try (BufferedReader errorReader =
                             new BufferedReader(new InputStreamReader(
                                     connection.getErrorStream()))) {
                    String errorLine;
                    StringBuilder errorResponse = new StringBuilder();
                    while ((errorLine = errorReader.readLine()) != null) {
                        errorResponse.append(errorLine);
                    }
                    System.err.println("Error response code: " + responseCode);
                    System.err.println("Error message: " + errorResponse.toString());
                    return null; // or handle the error as needed
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null; // or handle the exception as needed
        }
    }

    /**
     * Extracts the response from the ChatGPT API JSON.
     * @param jsonResponse
     * @return
     */
    public String extractContentFromResponse(final String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseObject = objectMapper.readTree(jsonResponse);

            if (responseObject.has("choices")) {
                JsonNode choicesNode = responseObject.get("choices").get(0);
                if (choicesNode.has("message")) {
                    JsonNode messageNode = choicesNode.get("message");
                    if (messageNode.has("content")) {
                        return messageNode.get("content").asText();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // or handle the absence of the "content" field as needed
    }


}
