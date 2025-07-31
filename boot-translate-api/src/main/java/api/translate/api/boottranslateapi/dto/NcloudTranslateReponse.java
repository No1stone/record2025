package api.translate.api.boottranslateapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NcloudTranslateReponse {
    @JsonProperty("message")
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Message {
        @JsonProperty("result")
        private Result result;

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        @JsonProperty("srcLangType")
        private String srcLangType;

        @JsonProperty("tarLangType")
        private String tarLangType;

        @JsonProperty("translatedText")
        private String translatedText;

        public String getSrcLangType() {
            return srcLangType;
        }

        public void setSrcLangType(String srcLangType) {
            this.srcLangType = srcLangType;
        }

        public String getTarLangType() {
            return tarLangType;
        }

        public void setTarLangType(String tarLangType) {
            this.tarLangType = tarLangType;
        }

        public String getTranslatedText() {
            return translatedText;
        }

        public void setTranslatedText(String translatedText) {
            this.translatedText = translatedText;
        }
    }
}
