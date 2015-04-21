package com.kadet.conveyor.machine;

import com.kadet.conveyor.container.Container;
import com.kadet.conveyor.controller.SessionManager;
import com.kadet.conveyor.entity.Personage;

import java.io.IOException;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public abstract class Machine<E> implements Runnable {

    protected Container<E> fromContainer;
    protected Container<E> toContainer;
    protected int count;

    public Machine(Container<E> fromContainer, Container<E> toContainer, int count) {
        this.fromContainer = fromContainer;
        this.toContainer = toContainer;
        this.count = count > 0 ? count : 0;
    }

    @Override
    public void run() {
        E item = fromContainer.poll();
        while (count != 0) {
            if (item != null) {
                item = processItem(item);
                try {
                    SessionManager.getInstance().notifyAll(getStage() + "/" + getDisplayName(item));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                toContainer.add(item);
                --count;
            }
            item = fromContainer.poll();
        }
    }

    protected String getDisplayName (E item) {
        if (item instanceof Personage) {
            Personage personage = (Personage)item;
            return personage.getId() + "/" + personage.getName() + " " + personage.getSurname() + ". " + personage.getKillWay();
        }
        return item.toString();
    }

    abstract protected String getStage ();

    abstract protected E processItem (E item);
}
