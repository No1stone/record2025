package ai.boot.bootai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PerplexityResponse(
        String id,
        String object,
        Long created,
        String model,
        List<Choice> choices) {

    public record Choice(
            int index,
            Message message,
            @JsonProperty("finish_reason") String finishReason) {}

    public record Message(String role, String content) {}
}

