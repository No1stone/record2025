package api.search.api.bootsearchapi.controller;

import api.search.api.bootsearchapi.service.DuckduckGoService;
import api.search.api.bootsearchapi.service.GoogleSearchApiService;
import api.search.api.bootsearchapi.service.YoutubeDataSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final GoogleSearchApiService googleSearchApiService;
    private final DuckduckGoService duckduckGoService;
    private final YoutubeDataSearchService youtubeDataSearchService;

    @GetMapping("/google/{text}")
    public Map<String, Object> test1(@PathVariable String text) {
       return googleSearchApiService.search(text);
    }

    @GetMapping("/duck/{text}")
    public String test2(@PathVariable String text) {
        return duckduckGoService.search(text);
    }

    @GetMapping("/youtube/{text}")
    public Map<String, Object> test3(@PathVariable String text) {
        return youtubeDataSearchService.search(text);
    }
}
