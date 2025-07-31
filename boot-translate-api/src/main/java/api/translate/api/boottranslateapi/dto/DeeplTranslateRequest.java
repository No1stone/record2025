package api.translate.api.boottranslateapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeeplTranslateRequest {

    @JsonProperty("text")
    private List<String> text;

    @JsonProperty("source_lang")
    private String sourceLang;

    @JsonProperty("target_lang")
    private String targetLang;

    public DeeplTranslateRequest(String text, String sourceLang, String targetLang) {
        this.text = Arrays.asList(text);
        this.sourceLang = sourceLang.toUpperCase();
        this.targetLang = targetLang.toUpperCase();
    }

    // Getter 생략 가능 (롬복 사용 시 @Getter 어노테이션 추가 가능)
}
