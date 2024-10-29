package de.neuefische.todobackend.chatgpt;

public record ChatGPTMessage(
        String role,
        String content
) {
}
