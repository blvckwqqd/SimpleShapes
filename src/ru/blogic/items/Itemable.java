package ru.blogic.items;

import ru.blogic.enums.Shape;

public interface Itemable {
    public static final int MAX_ITEM_SIZE = 5;
    public static final int MAX_CONTAINER_SIZE = 50;

    default int checkSize(int size) throws IllegalArgumentException {
        if(size > MAX_ITEM_SIZE || size < 1){
            throw new IllegalArgumentException("Неправильно указан размер предмета");
        } else{
            return size;
        }
    }
    default String checkString(String str){
        if(str.equals("")){
            throw new IllegalArgumentException("Указана нулевая строка");
        } else{
            return str;
        }
    }
    default int checkListSize(int size) throws IllegalArgumentException {
        if(size > MAX_CONTAINER_SIZE || size < 1){
            throw new IllegalArgumentException("Неправильно указан размер контейнера");
        } else{
            return size;
        }
    }




}
