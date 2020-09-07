package com.qas.web.functions;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;

@Lazy
@Component("box")
public class Box<T> {
    //put, get(key), get(map), size, clear, newBox
    private HashMap<String, T> box;

    public Box() {
        box = new HashMap<>();
    }

    public void put(String s, T t) {
        box.put(s, t);
    }

    public T get(String s) { //이해안감
        Function<String, T> f = p -> box.get(p);
        return f.apply(s);
    }

    public HashMap<String, T> get() {
        return box;
    }

    public void size(T t) {
        box.size();
    }

    public void clear() {
        box.clear();
    }

    public void newBox() {
        box = new HashMap<String, T>();
    }
}