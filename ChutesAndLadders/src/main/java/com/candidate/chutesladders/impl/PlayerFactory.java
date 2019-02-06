package com.candidate.chutesladders.impl;

import com.candidate.chutesladders.api.IPlayer;

import java.util.Objects;

/**
 * This factory class is designed keeping in mind future scalability of the application.
 * It can be used to provide different player objects for different versions of the game.
 *
 * @author Abhineet Kalra
 */
public class PlayerFactory {
    private static int counter;

    /**
     * @param name    Name of the player.
     * @param version version of the game for the requested player.
     * @return an {@link IPlayer} implementation depending upon version of the game.
     * @throws NullPointerException if null arguments are passed.
     */
    public static IPlayer getPlayer(String name, GameSpecifications.VERSIONS version) {

        Objects.requireNonNull(name, "Player name can't be null.");
        Objects.requireNonNull(version, "game version can't be null.");

        counter++;

        if (counter <= GameSpecifications.maxPlayers) {

            return new Player.aPlayer(name).withCurrentPlace(0).withId(counter - 1).build();

        } else {

            throw new IllegalArgumentException(String.format("Maximum %d players allowed in the game.", GameSpecifications.maxPlayers));

        }
    }
}
