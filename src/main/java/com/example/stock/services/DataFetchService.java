package com.example.stock.services;

import com.example.stock.entities.Coin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataFetchService {
        String ApiRequest() throws Exception {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://data.binance.com/api/v3/ticker/24hr"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }
    public List<Coin> getAllCoins() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String response = ApiRequest();

            Coin[] coins = objectMapper.readValue(response, Coin[].class);

            List<Coin> coinList = new ArrayList<>();

            Collections.addAll(coinList, coins);

            List<Coin> filteredList = coinList.stream()
                    .filter(coin -> coin.getLastPrice() != 0)
                    .collect(Collectors.toList());



            return filteredList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
