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
public class YoutubeDataSearchService {

    private final RestClient rc = RestClient.builder().build();
    private final static String baseUrl = "https://www.googleapis.com/youtube/v3";
    @Value("${key.search.google.api}")
    private String api;

    public Map<String, Object> search(String text) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/search")
                .queryParam("part", "snippet")
                .queryParam("q", text)
                .queryParam("maxResults", 10)
                .queryParam("key", api)
                .queryParam("type", "video")
                .queryParam("videoEmbeddable", "true")
                .toUriString();

        return rc.method(HttpMethod.GET)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Map.class);
    }
}



