package de.neuefische.todobackend.todo;

public record Todo(
        String id,
        String description,
        TodoStatus status
) {
}
