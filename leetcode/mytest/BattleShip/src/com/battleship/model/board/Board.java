package com.battleship.model.board;

public class Board {
    private Point [][] points;

    public Board(int xSize, int ySize){

        points = new Point[xSize][ySize];
        for(int i = 0; i < xSize ; i ++){
            for (int j =0 ; j < ySize; j++){
                Point point = new Point(i,j);
                points[i][j] = point;
            }
        }
    }

    public Point[][] getPoints() {
        return points;
    }

    public boolean isPointOnBoard(Point point){
        if(point.x > this.points.length || point.y > this.getPoints()[0].length){
            return false;
        }
        return true;
    }

}
