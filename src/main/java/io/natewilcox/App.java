package io.natewilcox;

import java.net.http.HttpClient;

public class App {
    public static void main(String[] args) {

        String type = "deaths";

        if (args.length == 1) {
            type = args[0];
        }

        HttpClient client = HttpClient.newBuilder().build();
        FetchService service = new HttpClientFetchService(client);
        Consumer consumer = new JacksonParserConsumer();

        Command cmd = new Command(type, service, consumer);
        cmd.execute();
    }
}
