package com.kadet.conveyor.machine;

import com.kadet.conveyor.container.Container;
import com.kadet.conveyor.entity.Personage;
import com.kadet.conveyor.util.DumbWayFactory;

import java.util.Random;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class DumbWayKiller extends Machine<Personage> {

    public DumbWayKiller(Container<Personage> fromContainer, Container<Personage> toContainer) {
        super(fromContainer, toContainer);
    }

    @Override
    protected String getStage() {
        return "killed";
    }


    @Override
    protected Personage processItem(Personage item) {
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        item.setKilled(true);
        item.setKillWay(DumbWayFactory.createWayToDie());
        return item;
    }

}
