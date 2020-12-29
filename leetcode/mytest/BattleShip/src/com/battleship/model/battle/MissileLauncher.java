package com.battleship.model.battle;

import com.battleship.model.board.Point;

import java.util.ArrayList;
import java.util.List;

public class MissileLauncher implements WeaponLauncher {


    String name = "MissileLauncher";
    String weaponType = "Missile";
    Integer capacity = 100;
    List<Missile> missiles;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MissileLauncher(){
        missiles = new ArrayList<>();
    }
    public MissileLauncher(List<Missile> missiles){
        this.missiles = missiles;
    }

    @Override
    public boolean aimAndFire(Point target) {
        if(missiles == null || missiles.isEmpty()) return  false;
        missiles.remove(missiles.size()-1);
        return true;
    }

    public void load(Missile missile) {
        this.missiles.add(missile);
    }

    @Override
    public boolean loadWeapons(Integer count) {
        while(missiles.size() < capacity){
            missiles.add(new Missile());
        }
        return true;
    }

    @Override
    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
}
