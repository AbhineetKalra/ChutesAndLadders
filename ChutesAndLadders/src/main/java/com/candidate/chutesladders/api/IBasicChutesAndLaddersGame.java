package com.candidate.chutesladders.api;

/**
 * This interface declares methods specific to a basic chutes and ladders game.
 *
 * @author Abhineet Kalra
 */
public interface IBasicChutesAndLaddersGame extends IGame {

    /**
     * @return Fully initialized {@link IPlayingBoard} object.
     */
    IPlayingBoard initalizePlayingBoard();

    /**
     * @return returns result of spin of a wheel depending upon the range provided.
     */
    int spinWheel();

}
