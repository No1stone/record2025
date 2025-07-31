package api.translate.api.boottranslateapi.controller;


import api.translate.api.boottranslateapi.dto.GoogleTranslateResponse;
import api.translate.api.boottranslateapi.service.DeepLTranslateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DeepLTranslateControoler {

    private final DeepLTranslateService deepLTranslateService;


    @GetMapping("/deepl/{text}")
    public String translate(@PathVariable String text) {
        return deepLTranslateService.translate(text,"EN","KO");
    }
}
