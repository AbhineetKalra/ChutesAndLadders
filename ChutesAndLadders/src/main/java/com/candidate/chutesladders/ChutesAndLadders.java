package com.candidate.chutesladders;

import com.candidate.chutesladders.impl.GameFactory;
import com.candidate.chutesladders.impl.GameSpecifications;

/**
 * Main class for starting up the chutes and ladders game.
 */
public class ChutesAndLadders {

    public static void main(String[] args) {
        GameFactory.getGame(GameSpecifications.VERSIONS.BASIC, args)
                .startGame();
    }

}
