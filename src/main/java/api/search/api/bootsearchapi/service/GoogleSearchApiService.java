package api.search.api.bootsearchapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoogleSearchApiService {

    @Value("${key.search.google.api}")
    private String api;

    @Value("${key.search.google.cx}")
    private String cx;

    public Map<String, Object> search(String query) {
        String url = UriComponentsBuilder
                .fromHttpUrl("https://www.googleapis.com/customsearch/v1")
                .queryParam("key", api)
                .queryParam("cx", cx)
                .queryParam("q", query)
                .toUriString();
        RestClient rc = RestClient.builder().build();
        return rc.method(HttpMethod.GET)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Map.class);
    }

}
