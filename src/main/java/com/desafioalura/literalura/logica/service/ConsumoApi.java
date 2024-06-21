package com.desafioalura.literalura.logica.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    HttpClient client = HttpClient.newHttpClient();
    String url = "https://gutendex.com/books";

    public String solicitudApi(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
            HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        String json;
        return json = response.body();
    }

    public void convertirDatos(String json){


    }



}
