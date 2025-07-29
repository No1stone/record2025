package ai.boot.bootai.config;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.model.tool.ToolCallingManager;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.ollama.management.ModelManagementOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigOllama {


    @Bean(name = "ollamaApi1")
    @Primary
    public OllamaApi ollamaApi1() {
        return new OllamaApi("http://localhost:11434"); // 첫 번째 Ollama API 엔드포인트
    }

    @Bean(name = "ollamaApi2")
    public OllamaApi ollamaApi2() {
        return new OllamaApi("http://localhost:11434"); // 두 번째 Ollama API 엔드포인트
    }

    @Bean(name = "ollamaOptions1")
    public OllamaOptions ollamaOptions1() {
        return OllamaOptions.builder().model("deepseek-r1:7b").build();
    }

    @Bean(name = "ollamaOptions2")
    public OllamaOptions ollamaOptions2() {
        return OllamaOptions.builder().model("exaone3.5:7.8b").build();
    }

    @Bean
    public ModelManagementOptions modelManagementOptions() {
        return ModelManagementOptions.defaults();
    }

    @Bean
    public ToolCallingManager toolCallingManager() {
        return ToolCallingManager.builder().build();
    }

    @Bean
    public ObservationRegistry observationRegistry() {
        return ObservationRegistry.create();
    }

    @Bean(name = "ollamaChatModel1")
    public OllamaChatModel ollamaChatModel1(
            OllamaApi ollamaApi1, OllamaOptions ollamaOptions1, ToolCallingManager toolCallingManager,
            ObservationRegistry observationRegistry, ModelManagementOptions modelManagementOptions) {
        return new OllamaChatModel(ollamaApi1, ollamaOptions1, toolCallingManager, observationRegistry, modelManagementOptions);
    }

    @Bean(name = "ollamaChatModel2")
    public OllamaChatModel ollamaChatModel2(
            OllamaApi ollamaApi2, OllamaOptions ollamaOptions2, ToolCallingManager toolCallingManager,
            ObservationRegistry observationRegistry, ModelManagementOptions modelManagementOptions) {
        return new OllamaChatModel(ollamaApi2, ollamaOptions2, toolCallingManager, observationRegistry, modelManagementOptions);
    }

}
