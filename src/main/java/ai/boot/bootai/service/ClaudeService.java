package ai.boot.bootai.service;

import ai.boot.bootai.dto.ClaudeRequest;
import ai.boot.bootai.dto.ClaudeResponse;
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
public class ClaudeService {

    @Value("${spring.ai.claude.url}")
    private String apiUrl;

    @Value("${spring.ai.claude.api-key}")
    private String apiKey;

    @Value("${spring.ai.claude.version}")
    private String apiVersion;

    private final RestClient restClient = RestClient.builder().build();

    public String getCompletion(String userMessage) {
        try {
            ClaudeRequest request = ClaudeRequest.create(userMessage);

            ClaudeResponse response = restClient.post()
                    .uri(apiUrl)
//                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                    .header("x-api-key", apiKey)
                    .header("anthropic-version", apiVersion)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .retrieve()
                    .body(ClaudeResponse.class);

            return response.content().get(0).text();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }


}
