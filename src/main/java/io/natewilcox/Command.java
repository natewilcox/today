package io.natewilcox;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class Command {

    private HttpClient client;

    public Command(String[] args) {

        this.client = HttpClient.newHttpClient();
    }

    public void execute() throws IOException, InterruptedException {

        LocalDate currentDate = LocalDate.now();

        String type = "deaths";
        int mm = currentDate.getMonthValue();
        int dd = currentDate.getDayOfMonth();

        String url = String.format("https://en.wikipedia.org/api/rest_v1/feed/onthisday/%s/%d/%d", type, mm, dd);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse response = this.client.send(request, BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree((String)response.body());
        
        JsonNode items = jsonNode.get(type);

        for(JsonNode item : items) {
            System.out.println(item.get("text").asText());
        }
    }
}
