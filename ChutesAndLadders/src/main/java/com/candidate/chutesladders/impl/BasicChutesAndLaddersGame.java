package com.candidate.chutesladders.impl;

import com.candidate.chutesladders.api.IBasicChutesAndLaddersGame;
import com.candidate.chutesladders.api.IPlayingBoard;
import com.candidate.chutesladders.api.IPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * An implementation of {@link com.candidate.chutesladders.api.IBasicChutesAndLaddersGame} containing major logic of the way
 * initializing, stating and playing the game.
 *
 * @author Abhineet Kalra
 */
class BasicChutesAndLaddersGame implements IBasicChutesAndLaddersGame {

    private final List<IPlayer> players;
    private final IPlayingBoard board;
    private final Spinner spinner;

    private IPlayer winner;
    private int totalTurns;

    BasicChutesAndLaddersGame(String[] playerNames) {

        Objects.requireNonNull(playerNames,"PlayerNames can't be null.");

        spinner = new Spinner();

        players = toPlayers(playerNames);

        board = initalizePlayingBoard();

        //First spin to decide who goes first.
        Collections.shuffle(players);

        totalTurns = 0;
    }

    @Override
    public void startGame() {
        while (!gameFinished()) {

            for (IPlayer player : players) {

                totalTurns++;
                String specialEvent = "\n";
                int currentPosition = player.getCurrentPlace();
                int spinResult = spinWheel();
                int newPosition = currentPosition + spinResult;

                System.out.printf("%d: %s: %d --> %d", totalTurns, player.getName(), currentPosition, newPosition);

                if (board.isLadder(newPosition)) {
                    newPosition = board.getLadderDestination(newPosition);
                    specialEvent = String.format(" --LADDER--> %d\n", newPosition);
                } else if (board.isChute(newPosition)) {
                    newPosition = board.getChuteDestination(newPosition);
                    specialEvent = String.format(" --CHUTE--> %d\n", newPosition);
                } else if (newPosition > GameSpecifications.boardSize) {
                    newPosition = currentPosition;
                    specialEvent = String.format(" --UNLUCKY--> %d\n", newPosition);
                }

                System.out.printf(specialEvent);
                player.updateCurrentPlace(newPosition);

                if (newPosition == GameSpecifications.boardSize) {
                    winner = player;
                    System.out.printf("The winner is %s!\n", winner.getName());
                    break;
                }
            }
        }
    }

    @Override
    public boolean gameFinished() {
        return winner != null;
    }

    @Override
    public IPlayingBoard initalizePlayingBoard() {
        IPlayingBoard board = new PlayingBoard();
        addLadders(board);
        addChutes(board);

        return board;
    }

    @Override
    public int spinWheel() {
        return spinner.spin();
    }

    private void addChutes(IPlayingBoard board) {

        board.addChute(16, 6);
        board.addChute(47, 26);
        board.addChute(49, 11);
        board.addChute(56, 53);
        board.addChute(62, 19);
        board.addChute(64, 60);
        board.addChute(87, 24);
        board.addChute(93, 73);
        board.addChute(95, 75);
        board.addChute(98, 78);
    }

    private void addLadders(IPlayingBoard board) {

        board.addLadder(1, 38);
        board.addLadder(4, 14);
        board.addLadder(9, 31);
        board.addLadder(21, 42);
        board.addLadder(28, 84);
        board.addLadder(36, 44);
        board.addLadder(51, 67);
        board.addLadder(71, 91);
        board.addLadder(80, 100);
    }

    private List<IPlayer> toPlayers(String[] players) {
        List<IPlayer> returnList = new ArrayList<>();
        for (String playerName : players) {
            IPlayer player = PlayerFactory.getPlayer(playerName, GameSpecifications.VERSIONS.BASIC);
            returnList.add(player);
        }
        return returnList;
    }
}
