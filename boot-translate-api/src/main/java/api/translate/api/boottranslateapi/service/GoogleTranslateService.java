package api.translate.api.boottranslateapi.service;

import api.translate.api.boottranslateapi.dto.GoogleTranslateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoogleTranslateService {

    private static final String TRANSLATE_API_URL = "https://translation.googleapis.com/language/translate/v2";

    @Value("${key.google.tanslate.apikey}")
    private String googleTranslateApiKey;


    public GoogleTranslateResponse translateText(String text, String targetLanguage) {
        String url = UriComponentsBuilder
                .fromHttpUrl(TRANSLATE_API_URL)
                .queryParam("q", text)
                .queryParam("target", targetLanguage)
                .queryParam("key", googleTranslateApiKey)
                .toUriString();
        log.info("trans - {}", url);
        RestClient rc = RestClient.builder().build();
        return rc.method(HttpMethod.GET)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(GoogleTranslateResponse.class);
    }

}
