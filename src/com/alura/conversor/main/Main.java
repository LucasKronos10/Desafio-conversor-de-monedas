package com.alura.conversor.main;

import com.alura.conversor.modelos.Conversor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner lectura = new Scanner(System.in);
        Conversor convertir = new Conversor();


        while (true) {
            System.out.println("""
                    ******************************************************************
                    Sea bienvenido/a al Conversor de Moneda =]
                    
                    0) Historial
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    8) Dólar =>> Peso chileno
                    9) Peso chileno =>> Dólar
                    10) Dólar =>> Boliviano boliviano
                    11) Boliviano boliviano =>> Dólar
                    7) Salir
                    
                    Elija una opción válida:
                    ******************************************************************
                    """);
            try {
                int opcion = lectura.nextInt();

                if (!(opcion >=1 && opcion <=6 || opcion >=8 && opcion <=11)) {
                    if (opcion == 7) {
                        System.out.println("Saliendo");
                        break;
                    } else if (opcion == 0) {
                         convertir.historial();
                        continue;
                    }else{
                        System.out.println("Numero no valido");
                        continue;

                    }
                }



                System.out.println("Ingrese el valor que desea convertir:");
                double monto = lectura.nextDouble();
                System.out.println("");
                String moneda_base;
                String modena_destino;
                switch (opcion){
                    case 1:
                        moneda_base ="USD";
                        modena_destino = "ARS";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;
                    case 2:
                        moneda_base ="ARS";
                        modena_destino = "USD";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;

                    case 3:
                        moneda_base ="USD";
                        modena_destino = "BRL";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;
                    case 4:
                        moneda_base ="BRL";
                        modena_destino = "USD";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;
                    case 5:
                        moneda_base ="USD";
                        modena_destino = "COP";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;
                    case 6:
                        moneda_base ="COP";
                        modena_destino = "USD";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;

                    case 8:
                        moneda_base ="USD";
                        modena_destino = "CLP";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;
                    case 9:
                        moneda_base ="CLP";
                        modena_destino = "USD";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;
                    case 10:
                        moneda_base ="USD";
                        modena_destino = "BOB";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;
                    case 11:
                        moneda_base ="BOB";
                        modena_destino = "USD";
                        convertir.convertir(moneda_base, modena_destino, monto);
                        break;



                }
            }catch (InputMismatchException e){
                System.out.println("espero un numero " + e.getMessage());
                break;
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Fin de la aplicacion");
                break;
            }

        }

    }
}
