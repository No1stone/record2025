package ai.boot.bootai.service;


import ai.boot.bootai.config.ConfigOpenAi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenaiService {

    private final ConfigOpenAi configOpenAi;

//    private final OpenAiChatModel openAiChatModel;
//
//    OpenaiService(@Qualifier("openAiChatModel") OpenAiChatModel openAiChatModel) {
//        this.openAiChatModel = openAiChatModel;
//    }
//
//    public String call(String text) {
//        return openAiChatModel.call(text);
//    }

        public String call(String text) {
        return configOpenAi.openAiChatModel().call(text);
    }

}
