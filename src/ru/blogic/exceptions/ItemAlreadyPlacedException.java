package ru.blogic.exceptions;

public class ItemAlreadyPlacedException extends RuntimeException {
    public ItemAlreadyPlacedException() {
        super("Этот предмет уже находится в контейнере");
    }
}
