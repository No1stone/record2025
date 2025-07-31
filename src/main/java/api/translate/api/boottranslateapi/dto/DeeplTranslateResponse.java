package api.translate.api.boottranslateapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeeplTranslateResponse {

    @JsonProperty("translations")
    private List<Translation> translations;

    public String getTranslatedText() {
        return translations.get(0).text;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Translation {

        @JsonProperty("detected_source_language")
        private String detectedSourceLanguage;

        @JsonProperty("text")
        private String text;
    }
}
