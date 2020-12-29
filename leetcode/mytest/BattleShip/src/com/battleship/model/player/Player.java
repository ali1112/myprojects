package com.battleship.model.player;


import com.battleship.model.board.Board;
import com.battleship.model.board.Point;
import com.battleship.model.battle.*;

import java.util.*;

public class Player {
    private String name;
    private Integer id;
    private List<WarShip> ships;

    private Map<Point, Integer> occupiedPoints;
    private Set<Point> myHitPoints;
    private Set<Point> firedAtPoints;
    private Set<Point> opponentHitPoints;

    public Player(){
        myHitPoints = new HashSet<>();
        firedAtPoints = new HashSet<>();
        ships = new ArrayList<>();
        occupiedPoints = new HashMap<>();
        opponentHitPoints = new HashSet<>();
    }
    public void addShip(WarShip ship){
        if(ship == null){
            ships = new ArrayList<WarShip>();
        }
        ships.add(ship);
        for(Point p : ship.getCoordinates()){
            occupiedPoints.put(p,ship.getId());
        }
    }

    public void fire(String shiptType, String weapon, Point p){
        for(WarShip ship: ships){
            if(shiptType.equalsIgnoreCase(ship.getShipType().getName())){
                ship.fire(weapon, p);
                firedAtPoints.add(p);
            }
        }
    }

    public boolean getHit(Point p, Board board){

        if(!board.isPointOnBoard(p)){
            return false;
        }
        myHitPoints.add(p);
        if(occupiedPoints.containsKey(p)){
            WarShip ship = getShipById(occupiedPoints.get(p));
            if (ship != null){
                if(shouldShipSunk(ship)){
                    this.sinkShip(ship);
                }
            }
            return true;
        }
        return false;
    }

    public boolean allShipLost(){
        for(WarShip warShip : this.ships){
            if(!warShip.isSunk()) return false;
        }
        return true;
    }


    private boolean shouldShipSunk(WarShip ship){

        for(Point point : ship.getCoordinates()){
            if(!myHitPoints.contains(point)) return false;
        }
        return true;
    }
    private WarShip getShipById(Integer id){
        for(WarShip ship : ships){
            if(id.equals(ship.getId())) return ship;
        }
        return  null;
    }
    public WarShip getShipByType(String shipType){
        for(WarShip ship : ships){
            if(shipType.equals(ship.getShipType().getName())) return ship;
        }
        return  null;
    }

    public void sinkShip(WarShip ship){
        if(ships == null) return;

        ship.sink();
    }

    public void drawMyBoard(Board board){
        System.out.println("            My board view for player "+this.name + "            Opponent's board view for player "+this.name);
        System.out.println();
        for(int i = 0; i < board.getPoints().length; i++) {
            System.out.print("      |       ");
            for (int j = 0; j < board.getPoints()[0].length; j++) {
                if (myHitPoints.contains(board.getPoints()[i][j]) && occupiedPoints.containsKey(board.getPoints()[i][j])) {
                    System.out.print(" $ ");
                    continue;
                }
                if (myHitPoints.contains(board.getPoints()[i][j])) {
                    System.out.print(" # ");
                    continue;
                }
                if (occupiedPoints.containsKey(board.getPoints()[i][j])) {
                    System.out.print(" * ");
                    continue;
                }

                System.out.print(" 0 ");
            }

            System.out.print("      |       ");
            for (int j = 0; j < board.getPoints()[0].length; j++) {
                if (opponentHitPoints.contains(board.getPoints()[i][j])) {
                    System.out.print(" $ ");
                    continue;
                }
                if (firedAtPoints.contains(board.getPoints()[i][j])) {
                    System.out.print(" # ");
                    continue;
                }

                System.out.print(" 0 ");
            }

            System.out.print("      |       ");

            System.out.println();
        }
    }

    public void drawOtherBoard(Board board){
        System.out.println("Opponent's board for player "+this.name);
        System.out.println();
        for(int i = 0; i < board.getPoints().length; i++) {
            for (int j = 0; j < board.getPoints()[0].length; j++) {
                if (opponentHitPoints.contains(board.getPoints()[i][j])) {
                    System.out.print(" $ ");
                    continue;
                }
                if (firedAtPoints.contains(board.getPoints()[i][j])) {
                    System.out.print(" # ");
                    continue;
                }

                System.out.print(" 0 ");
            }

            System.out.println();
        }
    }

    public Map<Point, Integer> getOccupiedPoints() {
        return occupiedPoints;
    }

    public Set<Point> getMyHitPoints() {
        return myHitPoints;
    }

    public Set<Point> getFiredAtPoints() {
        return firedAtPoints;
    }

    public Set<Point> getOpponentHitPoints() {
        return opponentHitPoints;
    }

    public void addWeapons(String shipType, String weapon, Integer count){
        for(WarShip ship : ships){
            if(ship.getShipType().getName().equals(shipType)){
                ship.addWeapons(weapon, count);
                break;
            }
        }
    }

    public void recordOpponentHit(Point point){
        opponentHitPoints.add(point);
    }

    public String getName(){
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

    public List<WarShip> getShips() {
        return ships;
    }

    public void setShips(List<WarShip> ships) {
        this.ships = ships;
    }
}
