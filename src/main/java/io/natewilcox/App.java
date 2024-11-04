package io.natewilcox;

import java.net.http.HttpClient;

public class App {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newBuilder().build();
        FetchService service = new HttpClientFetchService(client);
        Command cmd = new OnThisDayCommand("deaths", service);
        PrintTextCommandWrapper cmdPrinter = new PrintTextCommandWrapper(cmd);

        cmdPrinter.execute();
    }
}
