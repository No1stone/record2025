package api.translate.api.boottranslateapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NcloudTranslateRequest {

    private String source;
    private String target;
    private String text;
    private String glossaryKey;
    private String replaceInfo;
    private Boolean honorific;

    @Builder
    public NcloudTranslateRequest(String source, String target, String text, String glossaryKey, String replaceInfo, Boolean honorific) {
        this.source = source;
        this.target = target;
        this.text = text;
        this.glossaryKey = glossaryKey;
        this.replaceInfo = replaceInfo;
        this.honorific = honorific;
    }

}
