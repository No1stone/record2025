package ai.boot.bootai.config;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.ai.model.tool.ToolCallingManager;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class ConfigOpenAi {

    @Value("${spring.ai.openai.api-key}")
    private String chatGpt;

    @Bean(name = "openAiApi")
    public OpenAiApi openAiApi() {
        return new OpenAiApi("https://api.openai.com", chatGpt);
    }

    @Bean(name = "openAiChatOptions")
    public OpenAiChatOptions openAiChatOptions() {
        return OpenAiChatOptions.builder().model("gpt-4o-mini").build();
    }

    @Bean
    public RetryTemplate retryTemplate() {
        return RetryTemplate.builder()
                .maxAttempts(3) // 최대 3번 재시도
                .fixedBackoff(1000) // 1초 대기 후 재시도
                .build();
    }

    @Bean("openAiToolCallingManager")
    public ToolCallingManager toolCallingManager() {
        return ToolCallingManager.builder().build(); // 올바른 생성자 확인 필요
    }

    @Bean("oepnAiObservationRegistry")
    public ObservationRegistry observationRegistry() {
        return ObservationRegistry.create();
    }


    @Bean(name = "openAiChatModel")
    public OpenAiChatModel openAiChatModel() {
        OpenAiChatModel oacm = new OpenAiChatModel(openAiApi(), openAiChatOptions(), toolCallingManager(), retryTemplate() ,observationRegistry());
        return oacm;
    }

}
