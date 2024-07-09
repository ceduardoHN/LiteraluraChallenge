package com.curso.alura.literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    private static final String ADDRESS_PATH = "https://gutendex.com/books/";

    public String pruebaConsumo(String address){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
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
