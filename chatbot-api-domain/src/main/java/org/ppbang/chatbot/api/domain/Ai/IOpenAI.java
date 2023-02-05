package org.ppbang.chatbot.api.domain.Ai;

import java.io.IOException;

public interface IOpenAI {

    String doChatGPT(String openAiKey, String question) throws IOException;

}