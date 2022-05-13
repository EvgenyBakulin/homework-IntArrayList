package ru.skypro;

public interface MyIntList {
    int add(int item);

    int add(int index, int item);

    int set(int index, int item);

    int remove(int item);

    int removeToIndex(int index);

    boolean contains(int item);

    int indexOf(int item);

    int lastIndexOf(int item);

    int get(int index);

    boolean equals(MyIntList otherList);

    int size();

    boolean isEmpty();

    void clear();

}
