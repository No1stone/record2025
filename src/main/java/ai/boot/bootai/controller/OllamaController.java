package ai.boot.bootai.controller;

import ai.boot.bootai.service.OllamaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OllamaController {

    private final OllamaService ollamaService;

    @GetMapping("/ai-deep/{userText}")
    public String generation(@PathVariable(name = "userText") String userText) {

        log.info("userText - {}", userText);

        return ollamaService.deepseek(userText);
    }

    @GetMapping("/ai-lg/{userText}")
    public String generation2(@PathVariable(name = "userText") String userText) {

        log.info("userText - {}", userText);

        return ollamaService.lg(userText);
    }


}
