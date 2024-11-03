package io.natewilcox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonParserConsumer implements Consumer {

    @Override
    public void process(String type, String message) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            JsonNode json = mapper.readTree(message);
            JsonNode deaths = json.get(type);

            for (JsonNode node : deaths) {
                System.out.println(node.get("text").asText());
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
