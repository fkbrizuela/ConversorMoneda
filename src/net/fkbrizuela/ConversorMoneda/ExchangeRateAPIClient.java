package net.fkbrizuela.ConversorMoneda;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Properties;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class ExchangeRateAPIClient {
    String API_KEY = "8851634756c7748a2cc50421";

    BigDecimal GetExchangeRate(String moneda1, String moneda2) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moneda1 + "/" + moneda2))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        Properties apiResult = gson.fromJson(response.body(), Properties.class);
        String strconvRate = apiResult.getProperty("conversion_rate");
        Objects.requireNonNull(strconvRate, "El servicio de ExchangeRate-API no devolvió ninguna tasa de cambio.");
        return new BigDecimal(strconvRate);
    }
}
