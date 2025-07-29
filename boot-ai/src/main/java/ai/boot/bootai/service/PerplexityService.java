package ai.boot.bootai.service;

import ai.boot.bootai.dto.PerplexityRequest;
import ai.boot.bootai.dto.PerplexityResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class PerplexityService {

    @Value("${spring.ai.perplexity.url}")
    private String apiUrl;

    @Value("${spring.ai.perplexity.api-key}")
    private String apiKey;

    private final RestClient restClient = RestClient.builder().build();

    public String getCompletion(String userMessage) {
        try {
            PerplexityRequest request = PerplexityRequest.create(userMessage);

            PerplexityResponse response = restClient.post()
                    .uri(apiUrl)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .retrieve()
                    .body(PerplexityResponse.class);

            return response.choices().get(0).message().content();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

}
