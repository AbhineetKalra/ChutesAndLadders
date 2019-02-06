package com.candidate.chutesladders.impl;

import com.candidate.chutesladders.api.IGame;

import java.util.Objects;

/**
 * A factory class responsible for providing a game object depending upon the game version provided.
 *
 * @author Abhineet Kalra
 */
public class GameFactory {
    private static volatile IGame game;

    /**
     * A thread safe, factory, singleton function responsible for creating a new game object if there doesn't one that exists before.
     *
     * @param gameName Type of the game requested.
     * @param players  Name of the players playing the game.
     * @return returns a game object.
     * @throws IllegalArgumentException when the number of players provided are not within the range provided in {@link GameSpecifications}
     * @throws NullPointerException when arguments provided are null
     */
    public static IGame getGame(GameSpecifications.VERSIONS gameName, String[] players) {

        Objects.requireNonNull(gameName, "Game name should not be null.");
        Objects.requireNonNull(players, "Players should not be null.");

        if (players.length > GameSpecifications.maxPlayers || players.length < GameSpecifications.minPlayers) {
            throw new IllegalArgumentException(String.format("Number of players should be between %d - %d ", GameSpecifications.minPlayers, GameSpecifications.maxPlayers));
        }

        synchronized (GameFactory.class) {

            if (game == null) {

                switch (gameName) {
                    case BASIC:
                        game = new BasicChutesAndLaddersGame(players);
                        return game;
                    default:
                        throw new IllegalArgumentException("This Game has not yet been designed.");
                }

            } else {

                return game;

            }
        }
    }
}
