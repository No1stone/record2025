package ai.boot.bootai.controller;

import ai.boot.bootai.service.GeminiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GeminiController {

    private final GeminiService geminiService;

    @GetMapping("/gemini/{text}")
    public String geminiController(@PathVariable String text) {
        return geminiService.call(text);
    }

}
