package com.kadet.conveyor.entity;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class Personage {

    private String id;
    private String name;
    private String surname;

    private boolean wantPowerOrVengeance;
    private boolean haveFans;
    private boolean inConflict;
    private boolean killed;
    private String killWay = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isWantPowerOrVengeance() {
        return wantPowerOrVengeance;
    }

    public void setWantPowerOrVengeance(boolean wantPowerOrVengeance) {
        this.wantPowerOrVengeance = wantPowerOrVengeance;
    }

    public boolean isHaveFans() {
        return haveFans;
    }

    public void setHaveFans(boolean haveFans) {
        this.haveFans = haveFans;
    }

    public boolean isInConflict() {
        return inConflict;
    }

    public void setInConflict(boolean inConflict) {
        this.inConflict = inConflict;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public String getKillWay() {
        return killWay;
    }

    public void setKillWay(String killWay) {
        this.killWay = killWay;
    }
}
