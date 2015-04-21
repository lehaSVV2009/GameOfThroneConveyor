package com.kadet.conveyor.service;

import com.kadet.conveyor.machine.Machine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class ConveyorService {

    private List<Machine> machines = new ArrayList<>();

    public ConveyorService(List<Machine> machines) {
        this.machines = machines;
    }

    public void start () {
        for (Machine machine : machines) {
            new Thread(machine).start();
        }
    }
}
