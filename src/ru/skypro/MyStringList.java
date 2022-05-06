package ru.skypro;

import ru.skypro.exeptions.NullListEхeption;
import ru.skypro.exeptions.WrongIndexExeption;
import ru.skypro.exeptions.WrongItemExeption;

public interface MyStringList {
    String add(String item);

    String add(int index, String item) throws WrongIndexExeption;

    String set(int index, String item) throws WrongIndexExeption;

    String remove(String item) throws WrongItemExeption;

    String remove(int index) throws WrongIndexExeption;

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String get(int index) throws WrongIndexExeption;

    boolean equals(MyStringList otherList) throws NullListEхeption;

    int size();

    boolean isEmpty();

    void clear();

    String[] toArray();
}
