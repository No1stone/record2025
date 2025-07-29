package ai.boot.bootai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.ReactiveWebServerFactoryAutoConfiguration;

@SpringBootApplication(exclude = {ReactiveWebServerFactoryAutoConfiguration.class})
public class BootAiApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootAiApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        SpringApplication.run(BootAiApplication.class, args);
    }

}
