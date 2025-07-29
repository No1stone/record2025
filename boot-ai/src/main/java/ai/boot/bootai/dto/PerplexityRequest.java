package ai.boot.bootai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public  record PerplexityRequest(
        String model,
        List<Message> messages,
        Double temperature,
        @JsonProperty("max_tokens") Integer maxTokens) {

    public static PerplexityRequest create(String userMessage) {
        return new PerplexityRequest(
                "sonar", // 사용할 모델
                List.of(
                        new Message("system", "You are a helpful assistant."),
                        new Message("user", userMessage)
                ),
                0.7,
                100
        );
    }

    public record Message(String role, String content) {}
}