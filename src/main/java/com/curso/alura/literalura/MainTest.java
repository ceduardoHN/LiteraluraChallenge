package com.curso.alura.literalura;

import com.curso.alura.literalura.services.ConsumoAPI;
import com.curso.alura.literalura.api.ProcessData;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainTest {
    private String address = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ProcessData processData = new ProcessData();

    public void menu(){
        String json = consumoAPI.pruebaConsumo("https://gutendex.com/books/");
        System.out.println(json);
    }

    public void pruebaConsumo(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            System.out.println(json);
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
