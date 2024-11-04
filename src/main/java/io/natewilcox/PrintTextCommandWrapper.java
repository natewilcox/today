package io.natewilcox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintTextCommandWrapper {

    private Command command;

    public PrintTextCommandWrapper(Command command) {
        this.command = command;
    }

    public void execute() {

        String response = this.command.execute();
        ObjectMapper mapper = new ObjectMapper();

        try {

            JsonNode json = mapper.readTree(response);
            JsonNode nodes = json.elements().next();

            for (JsonNode node : nodes) {
                System.out.println(node.get("text").asText());
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
