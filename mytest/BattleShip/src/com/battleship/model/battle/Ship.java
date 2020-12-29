package com.battleship.model.battle;

import com.battleship.model.board.Point;

import java.util.List;
import java.util.Objects;

public abstract class Ship {

    protected String name;
    protected Integer id;
    protected  List<Point> coordinates;


    public abstract void sink();
    public abstract void moveTo(Point p);

    public List<Point> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Point> coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return Objects.equals(id, ship.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
