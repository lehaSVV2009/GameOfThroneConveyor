package com.kadet.conveyor.machine;

import com.kadet.conveyor.container.Container;
import com.kadet.conveyor.entity.Personage;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class WishMaker extends Machine<Personage> {

    public WishMaker(Container<Personage> fromContainer, Container<Personage> toContainer, int count) {
        super(fromContainer, toContainer, count);
    }

    @Override
    protected String getStage() {
        return "wish";
    }

    @Override
    protected Personage processItem(Personage item) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        item.setWantPowerOrVengeance(true);
        return item;
    }

}
