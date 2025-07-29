package ai.boot.bootai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ClaudeRequest(
        String model,
        List<Message> messages,
        @JsonProperty("max_tokens") Integer maxTokens) {

    public static ClaudeRequest create(String userMessage) {
        return new ClaudeRequest(
                "claude-3-5-sonnet-20241022", // 사용할 Claude 모델
                List.of(new Message("user", userMessage)),
                1000
        );
    }

    public record Message(String role, String content) {}
}
