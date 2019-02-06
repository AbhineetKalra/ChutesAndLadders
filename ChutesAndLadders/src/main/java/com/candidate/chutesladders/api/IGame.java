package com.candidate.chutesladders.api;

/**
 * This interface declares methods for any general game.
 *
 * @author Abhineet Kalra
 */
public interface IGame {

    /**
     * method to contain logic to start the game.
     */
    void startGame();

    /**
     * @return returns whether the game has finished or not.
     */
    boolean gameFinished();

}
