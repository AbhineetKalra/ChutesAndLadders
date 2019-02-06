Chutes and Ladders

This application is a programmatic representation for the game chutes and ladders. The application is designed keeping
in mind future scalability. Classes such as IGame and Game factory can be used to implement any common game. Moreover,
classes such as IPlayer, PlayerFactory and IBasicChutesAndLadders allow the application to support various different versions
which might be implemented later on.

Few Design features:
-> com.candidate.chutesladders.api package contains all the interfaces for the game while com.candidate.chutesladders.impl package contains their implementation.
-> Player class used builder pattern which makes building of player object easily readable and scalable.
-> PlayerFactory and GameFactory implements factory class pattern allowing the application to support different versions in future. 
-> GameFactory also uses singleton design pattern as only one game should be played at a given time.
-> All game related configuration such as min and max players, range of spinner is provided in GameSpecifications class.
-> Basic version of the game is implemented in BasicChutesAndLadderGame class. 

ChutesAndLadder class should be used to run the game.
java com.candidate.chutesladders.ChutesAndLadders Eric Paul

