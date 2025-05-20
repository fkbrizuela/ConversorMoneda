package net.fkbrizuela.ConversorMoneda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Objects;

public class Main {
    public static String readLine(String prompt) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String input = "";
        while(input.isEmpty()){
            System.out.println();
            System.out.print(prompt);
            input = reader.readLine();
        }
        return input;
    }

    public static String[][] monedas = {
            { "USD", "Dolar" },
            { "ARS", "Peso argentino" },
            { "BRL", "Real" },
            { "EUR", "Euro" },
            { "GBP", "Libra esterlina" },
            { "JPY", "Yen" },
            { "CNY", "Yuan" },
            { "MXN", "Peso mexicano" },
            { "UYU", "Peso uruguayo" },
    };

    public static void main(String[] args) {
        ExchangeRateAPIClient excClient = new ExchangeRateAPIClient();

        System.out.println("///// Conversor de monedas /////");
        System.out.println("Tipos de monedas soportadas: ");
        for (int i = 1; i <= monedas.length; i++) {
            System.out.println(i + ". " + monedas[i - 1][1]);
        }

        String monedaA;
        while (true) {
            try {
                String val = readLine("Seleccione una moneda para el monto a convertir, o " + (monedas.length + 1) + " para salir de la aplicación: ");
                int nval = Integer.parseInt(val);

                if (nval == monedas.length + 1)
                    System.exit(0);

                monedaA = monedas[nval - 1][0];
                break;
            } catch (Exception ignored) {
                System.out.println("Datos inválidos.");
            }
        }

        BigDecimal valorA;
        while (true) {
            try {
                String val = readLine("Tipee el monto a convertir, o \"salir\" para salir de la aplicacion: ");

                if (Objects.equals(val, "salir"))
                    System.exit(0);

                valorA = new BigDecimal(val);
                break;
            } catch (Exception ignored) {
                System.out.println("Datos invalidos.");
            }
        }

        String monedaB;
        while (true) {
            try {
                String val = readLine("Seleccione la moneda a la cual convertir, o " + (monedas.length + 1) + " para salir de la aplicacion: ");
                int nval = Integer.parseInt(val);

                if (nval == monedas.length + 1)
                    System.exit(0);

                monedaB = monedas[nval - 1][0];
                break;
            } catch (Exception ignored) {
                System.out.println("Datos inválidos.");
            }
        }

        try {
            BigDecimal exchange_rate = excClient.GetExchangeRate(monedaA, monedaB);
            System.out.println(valorA + " " + monedaA + " = " + valorA.multiply(exchange_rate) + " " + monedaB);
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println("Se produjo un error durante el calculo: " + e.getLocalizedMessage());
            System.exit(2);
        } catch (Exception e) {
            System.out.println("Error consultando ExchangeRate-API: " + e.getLocalizedMessage());
            System.exit(1);
        }
    }
}
