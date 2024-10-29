package de.neuefische.todobackend.todo.model;

public record UpdateTodo(
        String description,
        TodoStatus status
) {
}
