package com.desafioalura.literalura.logica.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsumoApi {

    HttpClient client = HttpClient.newHttpClient();
    String url = "https://gutendex.com/books";
    private ObjectMapper objectMapper = new ObjectMapper();

    public String solicitudApi(String busqueda){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/?search=" + busqueda.replace(" ", "%20")))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        String json = response.body();
        System.out.println(json);
        return json;
    }

    public <T> T convertirDatos(String json, Class<T>clase){
       try{
       return objectMapper.readValue(json, clase);
       } catch (JsonProcessingException e){
           throw new RuntimeException(e);
       }
    }

    }

