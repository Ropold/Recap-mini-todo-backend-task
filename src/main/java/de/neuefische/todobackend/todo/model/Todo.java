package de.neuefische.todobackend.todo.model;

public record Todo(
        String id,
        String description,
        TodoStatus status
) {
}
