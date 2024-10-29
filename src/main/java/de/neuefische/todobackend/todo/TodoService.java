package de.neuefische.todobackend.todo;

import de.neuefische.todobackend.todo.model.NewTodo;
import de.neuefische.todobackend.todo.model.Todo;
import de.neuefische.todobackend.todo.model.UpdateTodo;
import de.neuefische.todobackend.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final IdService idService;
    public final RestClient restClient;


    public TodoService (@Value("${app.openai-api-key}") String apiKey, RestClient.Builder builder,TodoRepository todoRepository, IdService idService) {
        this.restClient = builder
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
        this.todoRepository = todoRepository;
        this.idService = idService;
    }

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(NewTodo newTodo) {
        String id = idService.randomId();

        Todo todoToSave = new Todo(id, newTodo.description(), newTodo.status());

        return todoRepository.save(todoToSave);
    }

    public Todo updateTodo(UpdateTodo todo, String id) {
        Todo todoToUpdate = new Todo(id, todo.description(), todo.status());

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
