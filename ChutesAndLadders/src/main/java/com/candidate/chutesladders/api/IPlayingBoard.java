package com.candidate.chutesladders.api;

/**
 * This interface declares methods required for a chutes and ladder playing board.
 *
 * @author Abhineet Kalra
 */
public interface IPlayingBoard {

    /**
     * Method for adding ladder into the board.
     * @param from source of the ladder
     * @param to destination of the ladder.
     */
    void addLadder(int from, int to);

    /**
     * Method for adding chutes into the board.
     * @param from source of the chute.
     * @param to destination of the chute.
     */
    void addChute(int from, int to);


    /**
     * Method for indicating if a block is a ladder or not.
     * @param from position of the block to check
     * @return boolean indicating if a block is ladder or not.
     */
    boolean isLadder(int from);

    /**
     * Method for indicating if a block is a chute or not.
     * @param from position of the block to check
     * @return boolean indicating if a block is chute or not.
     */
    boolean isChute(int from);

    /**
     * @param from provide the source of chute.
     * @return returns the destination of the chute.
     */
    int getChuteDestination(int from);

    /**
     * @param from provide the source of ladder.
     * @return returns the destination of the ladder.
     */
    int getLadderDestination(int from);

}
