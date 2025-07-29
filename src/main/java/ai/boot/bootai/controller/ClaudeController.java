package ai.boot.bootai.controller;

import ai.boot.bootai.service.ClaudeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ClaudeController {

    private final ClaudeService claudeService;

    @GetMapping("/claude/{text}")
    public String call(@PathVariable String text) {
        return claudeService.getCompletion(text);
    }

}
