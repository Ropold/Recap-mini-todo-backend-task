package de.neuefische.todobackend.todo.model;

public record NewTodo(
        String description,
        TodoStatus status
) {
}
