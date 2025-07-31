package api.translate.api.boottranslateapi.service;

import api.translate.api.boottranslateapi.dto.DeeplTranslateRequest;
import api.translate.api.boottranslateapi.dto.DeeplTranslateResponse;
import api.translate.api.boottranslateapi.dto.GoogleTranslateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeepLTranslateService {

    @Value("${key.deepl.authkey}")
    private String deeplKey;
    private static final String DEEPL_URL = "https://api-free.deepl.com/v2/translate";

    public String translate(String text, String sourceLang, String targetLang) {
        DeeplTranslateRequest request = new DeeplTranslateRequest(text, sourceLang, targetLang);

        RestClient rc = RestClient.builder()
                .defaultHeader("Authorization", "DeepL-Auth-Key " + deeplKey)
                .defaultHeader("Content-Type", "application/json")
                .build();


        DeeplTranslateResponse response = rc.post()
                .uri(DEEPL_URL)
                .body(request)
                .retrieve()
                .body(DeeplTranslateResponse.class);

        return response.getTranslatedText();
    }

}
