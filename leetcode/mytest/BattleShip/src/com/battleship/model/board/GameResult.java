package com.battleship.model.board;

import com.battleship.model.player.Player;

public class GameResult {

    private boolean gameCompleted;
    private Player winner;

    public boolean isGameCompleted() {
        return gameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        this.gameCompleted = gameCompleted;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
