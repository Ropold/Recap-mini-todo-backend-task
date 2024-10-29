package de.neuefische.todobackend.todo;


import de.neuefische.todobackend.chatgpt.ChatGptApiService;
import de.neuefische.todobackend.todo.model.NewTodo;
import de.neuefische.todobackend.todo.model.Todo;
import de.neuefische.todobackend.todo.model.UpdateTodo;
import de.neuefische.todobackend.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final IdService idService;
    private final ChatGptApiService chatGptApiService;

    public TodoService(TodoRepository todoRepository, IdService idService, ChatGptApiService chatGptApiService) {
        this.todoRepository = todoRepository;
        this.idService = idService;
        this.chatGptApiService = chatGptApiService;
    }

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(NewTodo newTodo) {
        String id = idService.randomId();

        Todo todoToSave = new Todo(id, chatGptApiService.spellCheck(newTodo.description()), newTodo.status() );

        return todoRepository.save(todoToSave);
    }

    public Todo updateTodo(UpdateTodo todo, String id) {
        Todo todoToUpdate = new Todo(id, chatGptApiService.spellCheck(todo.description()), todo.status());

        return todoRepository.save(todoToUpdate);
    }

    public Todo findTodoById(String id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " not found!"));
    }

    public void deleteTodo(String id) {
        todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " not found!"));
        todoRepository.deleteById(id);
    }
}
