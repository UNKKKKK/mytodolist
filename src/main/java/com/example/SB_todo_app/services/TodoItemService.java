package com.example.SB_todo_app.services;

import com.example.SB_todo_app.models.TodoItem;
import com.example.SB_todo_app.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Optional;

public class TodoItemService {

    @Autowired
    private TodoItemRepository TodoItemRepository;

    public Iterable<TodoItem> getAll() {
        return TodoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long id) {
        return TodoItemRepository.findById(id);
    }

    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());
        }

        todoItem.setUpdatedAt(Instant.now());
        return TodoItemRepository.save(todoItem);
    }

    public void delete(TodoItem todoItem) {
        TodoItemRepository.delete(todoItem);
    }
}
