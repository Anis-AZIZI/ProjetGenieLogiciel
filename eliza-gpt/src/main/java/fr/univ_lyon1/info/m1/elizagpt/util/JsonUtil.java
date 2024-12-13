package fr.univ_lyon1.info.m1.elizagpt.util;

import java.util.Map;

/**
 * Utility class for handling JSON-related operations.
 */
public final class JsonUtil {

    /**
     * empecher l'utilitaire d'etre instancier.
     */
    private JsonUtil() { }
    /**
     * Converts a map of key-value pairs to a JSON-formatted string.
     *
     * @param map The map to convert to JSON.
     * @return The JSON-formatted string.
     */
    public static String mapToJson(final Map<Object, Object> map) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (json.length() > 1) {
                json.append(", ");
            }
            json.append('"').append(entry.getKey()).append("\":\"");
            if (entry.getValue() instanceof String) {
                json.append(entry.getValue());
            } else {
                json.append(entry.getValue().toString());
            }
            json.append('"');
        }
        json.append("}");
        return json.toString();
    }
}
