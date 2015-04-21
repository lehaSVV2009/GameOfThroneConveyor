package com.kadet.conveyor.container;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public abstract class Container<E> {

    private BlockingQueue<E> items = new ArrayBlockingQueue<>(50);

    public Container(List<E> items) {
        this.items.addAll(items);
    }

    public void add (E item) {
        items.add(item);
    }

    public E poll () {
        return items.poll();
    }

    public int size () {
        return items.size();
    }
}
