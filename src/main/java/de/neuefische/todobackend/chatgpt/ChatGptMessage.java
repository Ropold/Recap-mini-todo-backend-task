package de.neuefische.todobackend.chatgpt;

public record ChatGptMessage(
        String role,
        String content
) {
}
