package api.search.api.bootsearchapi.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class DuckduckGoService {


//    public Map<String, Object> search(String query) {

    public String search(String query) {
        String url = UriComponentsBuilder
                .fromHttpUrl("https://api.duckduckgo.com/")
                .queryParam("q", query)
                .queryParam("format", "json")
                .queryParam("pretty", 1)
                .queryParam("no_html", 1)
                .queryParam("skip_disambig", 1)
                .toUriString();
        log.info("duck - {}", url);
        RestClient rc = RestClient.builder().build();
        return rc.method(HttpMethod.GET)
                .uri(url)
                .header(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64)") // User-Agent 추가
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
    }
}
