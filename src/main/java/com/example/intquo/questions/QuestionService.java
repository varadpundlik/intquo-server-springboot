package com.example.intquo.questions;

import com.fasterxml.jackson.databind.node.DoubleNode;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class QuestionService {

    private static final Dotenv dotenv= Dotenv.load();
    private static final String GEMINI_API_KEY = dotenv.get("GEMINI_API_KEY");
    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + GEMINI_API_KEY;

    private final ObjectMapper mapper = new ObjectMapper();
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String getAIAnswer(String question) {
        try {
            // Create the JSON payload
            ObjectNode promptNode = mapper.createObjectNode();
            ObjectNode textNode = mapper.createObjectNode();
            textNode.put("text", question);
            promptNode.putArray("contents").addObject()
                    .put("role", "user")
                    .set("parts", mapper.createArrayNode().add(textNode));

            String requestBody = mapper.writeValueAsString(promptNode);

            // Build the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(GEMINI_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // Send request and parse response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectNode jsonResponse = (ObjectNode) mapper.readTree(response.body());

            System.out.println(response.body());

            return jsonResponse.path("candidates")
                    .path(0)
                    .path("content")
                    .path("parts")
                    .path(0)
                    .path("text")
                    .asText("No response from Gemini");

        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating AI answer.";
        }
    }
}
