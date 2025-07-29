package ai.boot.bootai.service;

import ai.boot.bootai.config.ConfigGemini;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeminiService {

    private final ConfigGemini configGemini;

    public String call(String text) {
        String result = "";
        try {
            result = configGemini.geminiChatModel().call(text);
        }
        catch (Exception e) {
            log.error("Failed to generate content: {}", e.getMessage(), e);
        }

        return result;
    }

}
