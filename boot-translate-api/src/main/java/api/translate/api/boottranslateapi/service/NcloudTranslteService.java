package api.translate.api.boottranslateapi.service;

import api.translate.api.boottranslateapi.dto.GoogleTranslateResponse;
import api.translate.api.boottranslateapi.dto.NcloudTranslateReponse;
import api.translate.api.boottranslateapi.dto.NcloudTranslateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class NcloudTranslteService {

    private final String ncloudUrl = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";

    @Value("${key.naver.papago.clientId}")
    private String clientId;

    @Value("${key.naver.papago.clientSecret}")
    private String clientSecret;

    public NcloudTranslateReponse translate(String text) {
        String url = UriComponentsBuilder
                .fromHttpUrl(ncloudUrl)
                .toUriString();
        log.info("trans - {}", url);
        NcloudTranslateRequest body =  NcloudTranslateRequest.builder()
                .source("en")
                .target("ko")
                .text(text)
                .build();

        RestClient rc = RestClient.builder().build();
        return rc.method(HttpMethod.POST)
                .uri(url)
                .header("X-NCP-APIGW-API-KEY-ID", clientId)
                .header("X-NCP-APIGW-API-KEY", clientSecret)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .accept(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .body(NcloudTranslateReponse.class);
    }


}
