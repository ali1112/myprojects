package com.battleship;

import com.battleship.game.Game;
import com.battleship.game.GamesHandler;
import com.battleship.model.battle.*;
import com.battleship.model.battle.Missile;
import com.battleship.model.board.Point;
import com.battleship.model.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player player1 = initPlayer1();
        Player player2 = initPlayer2();
        GamesHandler gamesHandler = new GamesHandler();
        gamesHandler.playGame(player1, player2);
    }

    private static  Player initPlayer1(){

        Player player = new Player();
        player.setId(1);
        player.setName("player1");
        // Board myBoard = new Board(10, 10);
        //Board otherBoard = new Board(10, 10);

        //player.setMyBoard(myBoard);
        //player.setOtherBoard(otherBoard);

        List<Point> carrierCords = Arrays.asList(new Point(2, 3), new Point(3,3),
                new Point(4,3), new Point(5,3), new Point(6,3));
        WarShip carrier = addWarShip("CARRIER",carrierCords, 5 );
        carrier.setId(1);

        List<Point> subMarineCords = Arrays.asList(new Point(8, 4), new Point(8,5),
                new Point(8,6));
        WarShip submarine = addWarShip("SUBMARINE",subMarineCords, 3 );
        submarine.setId(2);
        List<Point> cruiserCords = Arrays.asList(new Point(0, 4), new Point(0,5),
                new Point(0,6));
        WarShip cruiser = addWarShip("CRUISER",cruiserCords, 3 );
        cruiser.setId(3);

        List<Point> battleshipCords = Arrays.asList(new Point(3, 6), new Point(3,7),
                new Point(3,8), new Point(3,9));
        WarShip battleship = addWarShip("Battleship",battleshipCords, 3 );

        battleship.setId(4);
        List<Point> destroyerCords = Arrays.asList(new Point(7, 6), new Point(7,7));
        WarShip destroyer = addWarShip("Destroyer",destroyerCords, 2 );
        destroyer.setId(5);

        List<WarShip> warShips = new ArrayList<>();
//        warShips.add(carrier);
//        warShips.add(submarine);
//        warShips.add(cruiser);
        //warShips.add(destroyer);
        warShips.add(battleship);

        for(WarShip warShip : warShips){
            player.addShip(warShip);
        }
        return player;

//        List<Missile>  missiles = new ArrayList<>();
//        MissileLauncher missileLauncher = new MissileLauncher(missiles);
//        List<WeaponLauncher> weaponLaunchers = new ArrayList<>();
//        weaponLaunchers.add(missileLauncher);
//        WeaponCapabilities weaponCapabilities = new WeaponCapabilities(weaponLaunchers);
//        List<Point> cords = Arrays.asList(new Point(2, 3), new Point(3,3),
//                new Point(4,3), new Point(5,3), new Point(6,3));
//        WarShip warShip = new WarShip(new ShipType("CARRIER", 5), weaponCapabilities, cords);
//        warShip.addWeapons("Missile", 10);

    }

    private static Player initPlayer2(){

        Player player = new Player();
        player.setId(2);

        player.setName("player2");
        // Board board = new Board(boardXSize, boardYSize);
        // player.setOtherBoard(board);
        //Board myBoard = new Board(boardXSize, boardYSize);
        //player.setMyBoard(myBoard);

        List<Point> carrierCords = Arrays.asList(new Point(2, 3), new Point(3,3),
                new Point(4,3), new Point(5,3), new Point(6,3));
        WarShip carrier = addWarShip("CARRIER",carrierCords, 5 );
        carrier.setId(1);

        List<Point> subMarineCords = Arrays.asList(new Point(8, 4), new Point(8,5),
                new Point(8,6));
        WarShip submarine = addWarShip("SUBMARINE",subMarineCords, 3 );
        submarine.setId(2);
        List<Point> cruiserCords = Arrays.asList(new Point(0, 4), new Point(0,5),
                new Point(0,6));
        WarShip cruiser = addWarShip("CRUISER",cruiserCords, 3 );
        cruiser.setId(3);

        List<Point> battleshipCords = Arrays.asList(new Point(3, 6), new Point(3,7),
                new Point(3,8), new Point(3,9));
        WarShip battleship = addWarShip("Battleship",battleshipCords, 3 );

        battleship.setId(4);
        List<Point> destroyerCords = Arrays.asList(new Point(7, 6), new Point(7,7));
        WarShip destroyer = addWarShip("Destroyer",destroyerCords, 2 );
        destroyer.setId(5);

        List<WarShip> warShips = new ArrayList<>();
//        warShips.add(carrier);
//        warShips.add(submarine);
//        warShips.add(cruiser);
        warShips.add(destroyer);
        warShips.add(battleship);

        for(WarShip warShip : warShips){
            player.addShip(warShip);
        }
        return player;

//        List<Missile>  missiles = new ArrayList<>();
//        MissileLauncher missileLauncher = new MissileLauncher(missiles);
//        List<WeaponLauncher> weaponLaunchers = new ArrayList<>();
//        weaponLaunchers.add(missileLauncher);
//        WeaponCapabilities weaponCapabilities = new WeaponCapabilities(weaponLaunchers);
//        List<Point> cords = Arrays.asList(new Point(2, 3), new Point(3,3),
//                new Point(4,3), new Point(5,3), new Point(6,3));
//        WarShip warShip = new WarShip(new ShipType("CARRIER", 5), weaponCapabilities, cords);
//        warShip.addWeapons("Missile", 10);

    }

    public static WarShip addWarShip(String shipType, List<Point> cords, Integer missilesCount){
        List<Missile>  missiles = new ArrayList<>();
        MissileLauncher missileLauncher = new MissileLauncher(missiles);
        List<WeaponLauncher> weaponLaunchers = new ArrayList<>();
        weaponLaunchers.add(missileLauncher);
        WeaponCapabilities weaponCapabilities = new WeaponCapabilities(weaponLaunchers);
        WarShip warShip = new WarShip(new ShipType(shipType, missilesCount), weaponCapabilities, cords);
        warShip.addWeapons("Missile", missilesCount);
        return warShip;
    }
}
