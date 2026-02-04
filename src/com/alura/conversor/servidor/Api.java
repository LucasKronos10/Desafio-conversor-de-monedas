package com.alura.conversor.servidor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Api {
    String direccion = "https://v6.exchangerate-api.com/v6/";
    String clave = "tu-api-key";

    String moneda_base;
    String modena_destino;

    double montoParaConvertir;



    public HttpResponse<String> api(){
        try {
            URI URI_Final = URI.create(direccion + clave + "pair/" + moneda_base + "/" + modena_destino + "/" + montoParaConvertir);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI_Final)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Api(String moneda_base, String modena_destino, double montoParaConvertir) {
        this.moneda_base = moneda_base;
        this.modena_destino = modena_destino;
        this.montoParaConvertir = montoParaConvertir;
    }
}


