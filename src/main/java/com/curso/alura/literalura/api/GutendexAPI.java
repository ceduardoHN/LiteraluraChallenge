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
    private static final String ADDRESS_PATH = "https://gutendex.com/books/";

    public String getData(String address){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            if (json == null || json.isEmpty()) {
                throw new RuntimeException("La respuesta JSON está vacía");
            }

            return json;
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String searchBook(String bookName){
        String address = String.format("%s?search=%s",
                ADDRESS_PATH, bookName.trim().replace(" ", "%20"));

        return this.getData(address);
    }

    public String test(String address){
        return this.getData(ADDRESS_PATH+address);
    }
}
