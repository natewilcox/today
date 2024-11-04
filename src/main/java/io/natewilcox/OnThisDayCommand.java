package io.natewilcox;

import java.time.LocalDate;

public class OnThisDayCommand implements Command {

    FetchService service;

    private String type;
    private int mm;
    private int dd;

    public OnThisDayCommand(String type, FetchService service) {

        this.service = service;
        this.type = type;
        
        LocalDate currentDate = LocalDate.now();
        this.mm = currentDate.getMonthValue();
        this.dd = currentDate.getDayOfMonth();
    }

    @Override
    public String execute() {

        String url = String.format("https://en.wikipedia.org/api/rest_v1/feed/onthisday/%s/%d/%d", this.type, this.mm, this.dd);
        String response = this.service.get(url);
        return response;
    }
}
