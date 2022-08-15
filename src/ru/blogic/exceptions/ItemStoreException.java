package ru.blogic.exceptions;

public class ItemStoreException extends Exception{
    public ItemStoreException() {
        super("Превышен размер контейнера");
    }
}
