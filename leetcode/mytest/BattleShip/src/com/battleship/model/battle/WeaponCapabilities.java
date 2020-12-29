package com.battleship.model.battle;

import com.battleship.model.board.Point;

import java.util.ArrayList;
import java.util.List;

public class WeaponCapabilities {
    List<WeaponLauncher> weaponLaunchers;


    public WeaponCapabilities(){
    }

    public WeaponCapabilities(List<WeaponLauncher> weaponLaunchers){
        this.weaponLaunchers = weaponLaunchers;
    }
    public List<WeaponLauncher> getWeaponLaunchers() {
        return weaponLaunchers;
    }

    public void setWeaponLaunchers(List<WeaponLauncher> weaponLaunchers) {
        this.weaponLaunchers = weaponLaunchers;
    }

    public boolean fire(String weapon, Point target){
        for(WeaponLauncher weaponLauncher : weaponLaunchers){
            if(weaponLauncher.getName().equalsIgnoreCase(weapon)){
                return weaponLauncher.aimAndFire(target);
            }
        }
        return  false;
    }

    public void addWeapons(String weapon, Integer count){
        if(weaponLaunchers == null){
            weaponLaunchers = new ArrayList<>();
        }
        for(WeaponLauncher weaponLauncher : weaponLaunchers){
            if(weaponLauncher.getWeaponType().equals(weapon)){
                weaponLauncher.loadWeapons(count);
            }
        }
    }
}
