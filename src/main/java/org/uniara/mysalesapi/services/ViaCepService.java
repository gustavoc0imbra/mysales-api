package org.uniara.mysalesapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.uniara.mysalesapi.DTOs.ResponseViaCepAddressDTO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

@Service
public class ViaCepService {
    private final String BASE_URL = "https://viacep.com.br/ws/{cep}/json/";
    private ResponseViaCepAddressDTO addressDTO;

    public ResponseViaCepAddressDTO getAddress(String cep) {
        cep = formatCep(cep);

        try {
            HttpClient client = HttpClient.newBuilder()
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL.replace("{cep}", cep)))
                    .timeout(Duration.ofSeconds(20))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept((body) -> {
                        ObjectMapper objectMapper = new ObjectMapper();

                        try {
                            Map<String, String> map = objectMapper.readValue(body, Map.class);
                            addressDTO = new ResponseViaCepAddressDTO(
                                    map.get("cep").replace("-", ""),
                                    map.get("logradouro"),
                                    map.get("bairro"),
                                    map.get("localidade")
                            );
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    });

            return this.addressDTO;
        }catch (Exception e) {
            System.out.println("Error on getAddress: " + e.getMessage());
        }

        return null;
    }

    public String formatCep(String cep) {
        cep = cep.trim();
        cep = cep.replace(" ", "");
        cep = cep.replace("-", "");

        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP deve possuir 8 digitos");
        }

        return cep;
    }
}
