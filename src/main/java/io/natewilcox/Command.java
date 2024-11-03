package io.natewilcox;

import java.time.LocalDate;

public class Command {

    String type;
    FetchService service;
    Consumer consumer;

    public Command(String type, FetchService service, Consumer consumer) {
        this.type = type;
        this.service = service;
        this.consumer = consumer;
    }

    public void execute() {

        LocalDate currentDate = LocalDate.now();

        int mm = currentDate.getMonthValue();
        int dd = currentDate.getDayOfMonth();

        String url = String.format("https://en.wikipedia.org/api/rest_v1/feed/onthisday/%s/%d/%d", this.type, mm, dd);
        String response = this.service.get(url);

        this.consumer.process(this.type, response);
    }
}
