package com.candidate.chutesladders.impl;

import com.candidate.chutesladders.api.IPlayingBoard;

import java.util.HashMap;

/**
 * An implementation of IPlayingBoard providing methods for initializing and accessing the playing board.
 *
 * @author Abhineet Kalra
 */
public class PlayingBoard implements IPlayingBoard {

    private final HashMap<Integer, Integer> ladders;
    private final HashMap<Integer, Integer> chutes;

    public PlayingBoard() {

        this.ladders = new HashMap<>();
        this.chutes = new HashMap<>();
    }

    @Override

    public void addLadder(int from, int to) {
        ladders.put(from, to);
    }

    @Override
    public void addChute(int from, int to) {
        chutes.put(from, to);
    }

    @Override
    public boolean isLadder(int from) {
        return ladders.containsKey(from);
    }

    @Override
    public boolean isChute(int from) {
        return chutes.containsKey(from);
    }

    @Override
    public int getChuteDestination(int from) {
        return chutes.get(from);
    }

    @Override
    public int getLadderDestination(int from) {
        return ladders.get(from);
    }

}
