package ai.boot.bootai.controller;

import ai.boot.bootai.service.PerplexityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PerplexityController {

    private final PerplexityService perplexityService;

    @GetMapping("/perplexity/{text}")
    public String call(@PathVariable String text) {
        return perplexityService.getCompletion(text);
    }

}
