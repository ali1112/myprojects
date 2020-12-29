package com.battleship.game;

import com.battleship.model.battle.*;
import com.battleship.model.board.Board;
import com.battleship.model.board.Point;
import com.battleship.model.board.Result;
import com.battleship.model.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamesHandler {
    List<Player> players;
    List<Result> results;

    public void playGame(Player player1, Player player2){
        Game game = new Game();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        Result result = game.gameLoop();

    }




}
