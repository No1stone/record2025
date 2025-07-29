package ai.boot.bootai.service;

import ai.boot.bootai.config.ConfigOllama;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OllamaService {

    private final OllamaChatModel ollamaChatModel1;
    private final OllamaChatModel ollamaChatModel2;

    public String deepseek(String text){
        String responseAi = ollamaChatModel1.call(text);
        log.info("deep - {}", responseAi);
        return responseAi;
    }

    public String lg(String text){
        String responseAi = ollamaChatModel2.call(text);
        log.info("lg - {}", responseAi);
        return responseAi;
    }
}
