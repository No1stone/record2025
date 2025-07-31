package api.translate.api.boottranslateapi.controller;

import api.translate.api.boottranslateapi.dto.GoogleTranslateResponse;
import api.translate.api.boottranslateapi.dto.NcloudTranslateReponse;
import api.translate.api.boottranslateapi.service.GoogleTranslateService;
import api.translate.api.boottranslateapi.service.NcloudTranslteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class NcloudTranslateController {

    private final NcloudTranslteService ncloudTranslteService;

    @GetMapping("/naver/{text}")
    public NcloudTranslateReponse translate(@PathVariable String text) {
        return ncloudTranslteService.translate(text);
    }

}
