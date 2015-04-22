package com.kadet.conveyor.machine;

import com.kadet.conveyor.container.Container;
import com.kadet.conveyor.entity.Personage;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class FansMaker extends Machine<Personage> {

    public FansMaker(Container<Personage> fromContainer, Container<Personage> toContainer, Machine<Personage> nextMachine) {
        super(fromContainer, toContainer, nextMachine);
    }

    @Override
    protected String getStage() {
        return "fans";
    }

    @Override
    protected Personage processItem(Personage item) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        item.setHaveFans(true);
        return item;
    }

}
