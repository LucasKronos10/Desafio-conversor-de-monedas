package com.alura.conversor.modelos;

import com.alura.conversor.servidor.Api;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class Conversor {
List<String> lista = new ArrayList<>();

    public void convertir(String moneda_base, String modena_destino, Double montoParaConvertir) {
        Api api = new Api(moneda_base, modena_destino, montoParaConvertir);
        JsonElement elemento = JsonParser.parseString(api.api().body());
        JsonObject objeto = elemento.getAsJsonObject();
//        double tasa_conversion = objeto.get("conversion_rates").getAsDouble();
//        System.out.println(tasa_conversion);
//        double resultado = monton * tasa_conversion;
//
//        System.out.println("lo que voy a convertir "+ monton);
//        System.out.println("resultado " + resultado);
        System.out.println(moneda_base + " " + modena_destino + " " + montoParaConvertir);
        double resultado = objeto.get("conversion_result").getAsDouble();
        System.out.println("El valor " + montoParaConvertir + " [" + moneda_base +
                            "] corresponde al valor final de =>>> " + resultado + " [" + modena_destino + "]");

        String registro = String.format("| %-8s | %-8s | %24.2f | %19.2f | %tF | %tT |",
                moneda_base,
                modena_destino,
                montoParaConvertir,
                resultado,
                LocalDateTime.now(),
                LocalDateTime.now()

        );


        lista.add(registro);



    }

    public void historial(){
        if (!lista.isEmpty()) {
            System.out.println("historial disponible: ");
            System.out.println("");
            System.out.println("| ORIGEN   | DESTINO  |    MONTO-A-CONVERTIR     |  MONTO-CONVERTIDO   |    FECHA   |   HORA   |");
            System.out.println("|----------|----------|--------------------------|---------------------|------------|----------|");
            for (String linea : lista) {
                System.out.println(linea);
            }


        }else {
            System.out.println("no hay historial disponible");
        }



    }
}
