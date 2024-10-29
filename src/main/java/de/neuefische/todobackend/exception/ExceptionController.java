package de.neuefische.todobackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/exception")
public class ExceptionController {

    @GetMapping
    public String getException() {
        throw new NoSuchElementException("Id not found!");
    }

    @PostMapping
    public String addException() {
        throw new IllegalArgumentException("Exception");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleIllegalArgumentException(IllegalArgumentException exception) {
        return new ErrorMessage(exception.getMessage()+ " local");
    }
}