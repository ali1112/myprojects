package com.battleship.model.battle;

import com.battleship.model.board.Point;

public abstract class Weapon {
    String name;
    Integer range;

    public abstract boolean aimAndFire(Point p);

}
