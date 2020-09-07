package com.qas.web.functions;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Lazy
@Component("inventory")
public class Inventory<T> {
    private ArrayList<T> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void add(T t) {
        inventory.add(t);
    }

    public T get(int i) {
        Function<Integer, T> f = p -> get(p);
        return f.apply(i);
    }

    public ArrayList<T> get() {
        return inventory;
    }

    public void size() {
        inventory.size();
    }

    public void clear() {
        inventory.clear();
    }

    public void newInventory() {
        inventory = new ArrayList<T>();
    }

}
