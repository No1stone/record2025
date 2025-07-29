package ai.boot.bootai.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.PredictionServiceClient;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.ai.model.tool.ToolCallingManager;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.retry.support.RetryTemplate;

import java.io.IOException;
import java.util.List;

@Configuration
public class ConfigGemini {

    @Value("${spring.ai.gemini.api-key}")
    private String apiKey;

    @Value("${spring.ai.gemini.project-id}")
    private String projectId;

    @Value("${spring.ai.gemini.location}")
    private String location;

    @Value("${spring.ai.gemini.model}")
    private String model;

    @Value("classpath:/linear-aviary-298205-4522f5a43b70.json")
    private Resource credentialsPath;

    @Bean("geminiVertexAI")
    public VertexAI geminiVertexAI() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsPath.getInputStream());

        GoogleCredentials credentials2 = GoogleCredentials
                .fromStream(new ClassPathResource("linear-aviary-298205-4522f5a43b70.json").getInputStream())
                .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));


        return new VertexAI.Builder()
                 .setProjectId(projectId)
                 .setLocation(location)
                 .setCredentials(credentials2)
                 .build();
    }

    @Bean
    public PredictionServiceClient predictionServiceClient(VertexAI vertexAI) {
        return vertexAI.getPredictionServiceClient();
    }

    @Bean(name = "geminiChatOptions")
    public VertexAiGeminiChatOptions geminiChatOptions() {
        return VertexAiGeminiChatOptions.builder().model("gemini-1.5-pro").build();
    }

    @Bean("geminiRetryTemplate")
    public RetryTemplate geminiRetryTemplate() {
        return RetryTemplate.builder()
                .maxAttempts(3)
                .fixedBackoff(1000)
                .build();
    }

    @Bean("geminiToolCallingManager")
    public ToolCallingManager toolCallingManager() {
        return ToolCallingManager.builder().build();
    }

    @Bean("geminiObservationRegistry")
    public ObservationRegistry observationRegistry() {
        return ObservationRegistry.create();
    }

    @Bean(name = "geminiChatModel")
    public VertexAiGeminiChatModel geminiChatModel() throws IOException {
        return new VertexAiGeminiChatModel(this.geminiVertexAI(), geminiChatOptions(), toolCallingManager(), geminiRetryTemplate(), observationRegistry());
    }

}
