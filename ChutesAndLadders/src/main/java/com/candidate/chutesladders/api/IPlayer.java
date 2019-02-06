package com.candidate.chutesladders.api;

/**
 * This interface declares methods specific to a player playing the game.
 *
 * @author Abhineet Kalra
 */
public interface IPlayer {

    /**
     * @return returns the name of the player.
     */
    String getName();

    /**
     * @return returns the current position of the player on the board.
     */
    int getCurrentPlace();

    /**
     * Updates the current position of the player .
     *
     * @param updatedPlace updated position of the player.
     */
    void updateCurrentPlace(int updatedPlace);
}
