package com.candidate.chutesladders.impl;

import com.candidate.chutesladders.api.IPlayer;

import java.util.Objects;

/**
 * An builder pattern implementation of the {@link IPlayer} interface providing players for {@link com.candidate.chutesladders.api.IBasicChutesAndLaddersGame}
 *
 * @author Abhineet Kalra
 */
public class Player implements IPlayer {

    private final String name;
    private final int id;
    private int currentPlace;

    private Player(aPlayer player) {
        this.name = player.name;
        this.id = player.id;
        this.currentPlace = player.currentPlace;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCurrentPlace() {
        return currentPlace;
    }

    @Override
    public void updateCurrentPlace(int updatedPlace) {
        currentPlace = updatedPlace;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", currentPlace=" + currentPlace +
                '}';
    }

    public static final class aPlayer {
        private String name;
        private int currentPlace;
        private int id;

        public aPlayer(String name) {
            Objects.requireNonNull(name, "Name of the player can't be null");
            this.name = name;
        }


        public aPlayer withCurrentPlace(int currentPlace) {
            this.currentPlace = currentPlace;
            return this;
        }

        public aPlayer withId(int id) {
            this.id = id;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
