package com.kadet.conveyor.machine;

import com.kadet.conveyor.container.Container;
import com.kadet.conveyor.entity.Personage;
import com.kadet.conveyor.util.DumbWayFactory;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class DumbWayKiller extends Machine<Personage> {

    public DumbWayKiller(Container<Personage> fromContainer, Container<Personage> toContainer, int count) {
        super(fromContainer, toContainer, count);
    }

    @Override
    protected String getStage() {
        return "killed";
    }


    @Override
    protected Personage processItem(Personage item) {
        item.setKilled(true);
        item.setKillWay(DumbWayFactory.createWayToDie());
        return item;
    }

}
