//package com.battleship.model;
//
//import com.battleship.model.board.Point;
//
//import java.util.List;
//import java.util.Objects;
//
//public abstract class Ship {
//
//    private String name;
//    private Integer id;
//    private  List<Point> coordinates;
//    private List<? extends Weapon> weapons;
//
//    public boolean fire(Weapon weapon, Point p){
//        if(weapons == null || weapons.isEmpty()) return false;
//        for(Weapon w : weapons){
//            if(w.getName().equals(weapon.getName())){
//                w.fire();
//                break;
//            }
//        }
//        weapons.remove(weapon);
//        return true;
//    }
//    public abstract void getHit(Point x, Point y);
//    public abstract void sink();
//    public abstract void swim();
//
//    public List<Point> getCoordinates() {
//        return coordinates;
//    }
//
//    public void setCoordinates(List<Point> coordinates) {
//        this.coordinates = coordinates;
//    }
//
//    public List<Weapon> getWeapons() {
//        return weapons;
//    }
//
//    public void setWeapons(List<Weapon> weapons) {
//        this.weapons = weapons;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Ship)) return false;
//        Ship ship = (Ship) o;
//        return Objects.equals(id, ship.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
