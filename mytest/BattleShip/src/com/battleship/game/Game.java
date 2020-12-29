package com.battleship.game;

import com.battleship.model.board.Board;
import com.battleship.model.board.GameResult;
import com.battleship.model.board.Point;
import com.battleship.model.board.Result;
import com.battleship.model.player.Player;
import com.battleship.model.battle.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    Integer boardXSize =10, boardYSize =10;
    Integer id;
    private Player player1;
    private Player player2;
    private Board board;
//    private Board board2;
    private Result result;
    private boolean isRunning;


    public Game(){

    }


    public Result gameLoop()
    {
        //player1 = initPlayer1();
        //player2 = initPlayer2();
        Result result = new Result();

        board = new Board(boardXSize,boardYSize);
        List<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        isRunning=true;
        draw();
          while(isRunning){
              Player playerTurn = players.get(players.size()-1);
              Player otherPlayer = players.get(players.size()-2);
              players.remove(players.size()-1);
              Input input = new Input();
              takeInput(playerTurn, input);
              Point target = new Point(input.xTarget, input.yTarget);
              playerTurn.fire(input.shipType, "Missile", target);
              boolean hitAtShip = otherPlayer.getHit(target, board);
              if(hitAtShip){
                  playerTurn.recordOpponentHit(target);
              }
              draw();

              if(otherPlayer.allShipLost()){
                  System.out.println("Player: "+playerTurn.getName()+ " won the Game !!! ");
                  result.setGameId(this.id);
                  GameResult gameResult = new GameResult();
                  gameResult.setGameCompleted(true);
                  gameResult.setWinner(playerTurn);
                  result.setGameResult(gameResult);
                  isRunning=false;
                  break;
              }
              players.add(0, playerTurn);
              try{
                  Thread.sleep(1000); //the timing mechanism
              }catch (Exception ex){
                  isRunning = false;
              }
              if (!isRunning)
              {
                  break;
              }
          }
          return result;
    }

    class Input{
        String shipType;
        Integer xTarget;
        Integer yTarget;
    }
    private void takeInput(Player player, Input playerInput){

        System.out.println("-----------------------------------------------------------------" +
                "---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Player: "+player.getName()+ " turn");
        System.out.println(" Press 9 to end game");

        System.out.println();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player: "+player.getName()+ " turn");
        System.out.println("Enter fire instructions in following format:");
        System.out.println("Fire [weapon] to target [x,y]");
        System.out.println("Available weapons are following");
        System.out.println("" + "\n" + "Carrier" + "\n" + "Cruiser" + "\n" + "BattleShip" + "\n" + "Destroyer" + "\n" + "Submarine" + "\n" );
        System.out.println();
        String scannedInput = scanner.nextLine();
        if(checkAbortGameRequest(scannedInput)){
            isRunning = false;
            return;
        }
        String pattern = "(?<=\\[)(.*?)(?=\\])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(scannedInput);
            //m.group();
        List<String> inputs = new ArrayList<>();
        while (m.find()) {
            //System.out.println(m.group());
            inputs.add(m.group());
            //System.out.println("Found value: " + m.group(0) );
        }
        if(!parseInput(player, inputs, playerInput)){
            System.out.println("Invalid input, Please enter the input in correct format");
            takeInput(player, playerInput);
        }

        return;
    }


    private boolean checkAbortGameRequest(String input){
        try{
            if(Integer.parseInt(input) == 9) return true;
        }catch (Exception e){
            return false;
        }
        return false;
    }
    private boolean parseInput(Player player, List<String> inputKeys, Input playerInput){

        if(inputKeys == null || inputKeys.size() != 2) return false;

        String [] tokens = inputKeys.get(1).split(",");
        if(tokens.length != 2) return  false;
        if(player.getShipByType(inputKeys.get(0)) != null){
            playerInput.shipType = inputKeys.get(0);
        }else{
            return false;
        }

        try{
            playerInput.xTarget = Integer.parseInt(tokens[0]);
            playerInput.yTarget = Integer.parseInt(tokens[1]);

        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

    private Integer readIntInput(Scanner in, Player player, Input playerInput){
        String s = in.nextLine();
        Integer input = 9;
        try{
            input = Integer.parseInt(s);
        }
        catch (Exception ex){
            System.out.println("Invalid input, Please Try Again");
            takeInput(player, playerInput);
        }
        return input;
    }
    private void isEndGameInput(){
        isRunning = false;
    }
    private String getShipTypeForInput(Integer in){
        switch (in){
            case 1:
                    return "Carrier";
            case 2:
                return "Cruiser";
            case 3:
                return "BattleShip";
            case 4:
                return "Destroyer";
            case 5:
                return "Submarine";
            case 9:
                isEndGameInput();
            break;
        }
        return null;
    }
    private void draw(){
        clearScreen();
        player1.drawMyBoard(board);
        //player1.drawOtherBoard(board);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        player2.drawMyBoard(board);
       // player2.drawOtherBoard(board);

    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Integer getBoardXSize() {
        return boardXSize;
    }

    public void setBoardXSize(Integer boardXSize) {
        this.boardXSize = boardXSize;
    }

    public Integer getBoardYSize() {
        return boardYSize;
    }

    public void setBoardYSize(Integer boardYSize) {
        this.boardYSize = boardYSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
