package com.battleship.model.battle;

import com.battleship.model.board.Point;

import java.util.List;

public class WarShip extends Ship {

    private Integer id;
    private boolean isSunk;
    private ShipType shipType;
    WeaponCapabilities weaponCapabilities;

    public WarShip(ShipType shipType, WeaponCapabilities weaponCapabilities, List<Point> cords) {
        this.coordinates = cords;
        this.shipType = shipType;
        this.weaponCapabilities = weaponCapabilities;

    }

    @Override
    public void sink() {
        isSunk = true;
    }
    @Override
    public void moveTo( Point p) {

    }

    public  boolean fire(String weapon, Point target){
        return  weaponCapabilities.fire(weapon, target);
    }

    public void addWeapons(String weapon, Integer count){
        weaponCapabilities.addWeapons(weapon, count);
    }
    public void getHit(Point x, Point y){

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public WeaponCapabilities getWeaponCapabilities() {
        return weaponCapabilities;
    }

    public void setWeaponCapabilities(WeaponCapabilities weaponCapabilities) {
        this.weaponCapabilities = weaponCapabilities;
    }
}
