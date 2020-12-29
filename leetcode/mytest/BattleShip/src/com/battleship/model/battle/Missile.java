package com.battleship.model.battle;

import com.battleship.model.board.Point;

public class Missile extends Weapon {

    String name = "Missile";
    @Override
    public boolean aimAndFire(Point p) {
        return false;
    }
}
