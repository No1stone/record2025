package api.translate.api.boottranslateapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleTranslateResponse {
    @JsonProperty("data")
    private Data data;

    public Data getData() {
        return data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("translations")
        private List<Translation> translations;

        public List<Translation> getTranslations() {
            return translations;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Translation {
        @JsonProperty("translatedText")
        private String translatedText;

        public String getTranslatedText() {
            return translatedText;
        }
    }
}