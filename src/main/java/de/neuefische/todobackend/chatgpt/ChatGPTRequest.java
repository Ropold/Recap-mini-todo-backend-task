package de.neuefische.todobackend.chatgpt;

import java.util.List;

public record ChatGPTRequest(
        String model,
        List<ChatGPTMessage> messages
) {
    ChatGPTRequest(String message) {
        this("gpt-3.5-turbo", List.of(new ChatGPTMessage("user", message)));
    }
}
