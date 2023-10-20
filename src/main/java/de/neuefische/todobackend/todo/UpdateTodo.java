package de.neuefische.todobackend.todo;

public record UpdateTodo(
        String description,
        TodoStatus status
) {
}
