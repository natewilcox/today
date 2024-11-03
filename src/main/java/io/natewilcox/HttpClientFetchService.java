package io.natewilcox;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientFetchService implements FetchService {

    private HttpClient client;

    public HttpClientFetchService(HttpClient client) {

        this.client = client;
    }

    @Override
    public String get(String url) {

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = null;

		try {
			response = this.client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

        return response != null ? response.body() : null;
    }
}
