package org.example;

public class Items<T> {

    private T[] items;
    private int size;

    public Items(T[] items, int size) {
        this.items = items;
        this.size = size;
    }

    public boolean contains(T value, boolean identity) {
        T[] items = this.items;
        int i = size - 1;
        if (identity || value == null) {
            while (i >= 0)
                if (items[i--] == value) return true;
        } else {
            while (i >= 0)
                if (value.equals(items[i--])) return true;
        }
        return false;
    }
}