package com.candidate.chutesladders.impl;

import java.util.Random;

/**
 * Spinner responsible for generating random numbers within a provided range demonstrating a spinner in any game.
 *
 * @author Abhineet Kalra
 */
public class Spinner {
    public final Random randomizer = new Random();

    /**
     * @return returns a random integer within the range mention in GameSpecifications.
     */
    int spin() {
        return GameSpecifications.minSpin + randomizer.nextInt(GameSpecifications.maxSpin - GameSpecifications.minSpin);
    }
}
