import com.battleship.model.board.Point;

import java.util.List;

public class Destroyer extends Ship{

    public  Destroyer(List<Weapon> weapons, List<Point> coordinates){
        this.setName("BattleShip");
        this.setWeapons(weapons);
        this.setCoordinates(coordinates);
    }

    @Override
    public void sink() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void getHit(Point x, Point y) {

    }
}
