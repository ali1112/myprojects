package com.battleship.model.battle;

import com.battleship.model.board.Point;

public interface WeaponLauncher {

    public String getName();
    public String getWeaponType();
    public boolean aimAndFire(Point target);
    public boolean loadWeapons(Integer count);

}
