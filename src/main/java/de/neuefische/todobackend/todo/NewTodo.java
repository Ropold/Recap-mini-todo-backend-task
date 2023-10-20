package de.neuefische.todobackend.todo;

public record NewTodo(
        String description,
        TodoStatus status
) {
}
