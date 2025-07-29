package ai.boot.bootai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ClaudeResponse(
        String id,
        String type,
        String role,
        List<Content> content,
        Usage usage,
        @JsonProperty("stop_reason")
        String stopReason

) {

    public record Content(
             String type,
             String text
    ){}

    public record Usage(
            @JsonProperty("input_tokens") int inputTokens,
            @JsonProperty("output_tokens") int outputTokens) {}
}
