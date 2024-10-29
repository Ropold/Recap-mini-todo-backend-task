package de.neuefische.todobackend.chatgpt;

import java.util.List;

public record ChatGptRequest(
        String model,
        List<ChatGptMessage> messages,
        ChatGptFormat response_format
) {
//    ChatGptRequest(String message) {
//        this("gpt-3.5-turbo", List.of(new ChatGptMessage("user", message)));
//    }
}
