package api.translate.api.boottranslateapi.controller;

import api.translate.api.boottranslateapi.dto.GoogleTranslateResponse;
import api.translate.api.boottranslateapi.service.GoogleTranslateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GoogleTranslateController {

    private final GoogleTranslateService googleTranslateService;

    @GetMapping("/google/{text}")
    public GoogleTranslateResponse translate(@PathVariable String text) {
        return googleTranslateService.translateText(text,"ko");
    }

}
