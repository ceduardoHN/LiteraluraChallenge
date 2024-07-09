package com.curso.alura.literalura.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Soriano
 */
public class GutendexAPI {
    private static final String ADDRESS_PATH = "https://gutendex.com/books";

    public String test(String address){
        String url = String.format("%s/%s",
                ADDRESS_PATH, address);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            return json;
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
